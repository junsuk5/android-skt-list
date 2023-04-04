package com.surivalcoding.listexam.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.surivalcoding.listexam.data.Number
import androidx.recyclerview.widget.RecyclerView
import com.surivalcoding.listexam.R

//interface OnClickListenre {
//    void onClicked(String value);
//}

class NumberAdapter(
    private val onClicked: (Number) -> Unit,
    private val onLongClicked: (Number) -> Unit,
) : ListAdapter<Number, NumberAdapter.ViewHolder>(
    object : ItemCallback<Number>() {
        override fun areItemsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem.value == newItem.value
        }

        override fun areContentsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem == newItem
        }
    }
) {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.textView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        println(position)

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val number = getItem(position)

        viewHolder.textView.text = number.value.toString()

        if (position % 2 == 1) {
            viewHolder.textView.setTextColor(Color.RED)
            viewHolder.itemView.setBackgroundColor(Color.BLUE)
        } else {
            viewHolder.textView.setTextColor(Color.GRAY)
            viewHolder.itemView.setBackgroundColor(Color.RED)
        }

        if (number.isSelected) {
            viewHolder.itemView.setBackgroundColor(Color.WHITE)
        }

        // 클릭 이벤트 정의
        viewHolder.itemView.setOnClickListener {
            // 콜백으로 처리하는 부분으로 돌려줘야 함
//            println(dataSet[viewHolder.adapterPosition])
            onClicked(getItem(viewHolder.adapterPosition))
        }

        viewHolder.itemView.setOnLongClickListener {
            onLongClicked(getItem(viewHolder.adapterPosition))
            return@setOnLongClickListener true
        }

    }

}

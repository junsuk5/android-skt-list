package com.surivalcoding.listexam

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//interface OnClickListenre {
//    void onClicked(String value);
//}

class NumberAdapter(
    private var dataSet: List<Int> = emptyList(),
    private var clickedItems: Set<Int> = emptySet(),
    private val onClicked: (Int) -> Unit,
    private val onLongClicked: (Int) -> Unit,
) : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

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
        viewHolder.textView.text = dataSet[position].toString()

        if (position % 2 == 1) {
            viewHolder.textView.setTextColor(Color.RED)
            viewHolder.itemView.setBackgroundColor(Color.BLUE)
        } else {
            viewHolder.textView.setTextColor(Color.GRAY)
            viewHolder.itemView.setBackgroundColor(Color.RED)
        }

        if (clickedItems.contains(dataSet[position])) {
            viewHolder.itemView.setBackgroundColor(Color.WHITE)
        }

        // 클릭 이벤트 정의
        viewHolder.itemView.setOnClickListener {
            // 콜백으로 처리하는 부분으로 돌려줘야 함
//            println(dataSet[viewHolder.adapterPosition])
            onClicked(dataSet[viewHolder.adapterPosition])
        }

        viewHolder.itemView.setOnLongClickListener {
            onLongClicked(dataSet[viewHolder.adapterPosition])
            return@setOnLongClickListener true
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun submitList(state: MainUiState) {
        dataSet = state.items
        clickedItems = state.clickedItems
        notifyDataSetChanged()
    }

}

package ui.smartpro.cleanarchgeekbrains.ui.translate.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildLayoutPosition(view)
        val itemCount = parent.adapter?.itemCount ?: 0
        if (position == RecyclerView.NO_POSITION) {
            outRect.set(0, 0, 0, 0)
            return
        }

        val (left, right) = if (position % 2 == 0) Pair(39, 9) else Pair(9, 39)
        outRect.left = left
        outRect.right = right
        outRect.top = if (position == 0) 14 else 7
        outRect.bottom = if (position == itemCount - 1) 14 else 7
    }
}
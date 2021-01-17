package com.param.stickyheader

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ViewRetriever {
    fun getViewHolderForPosition(headerPosition: Int): RecyclerView.ViewHolder

    class RecyclerViewRetriever(
        private val recyclerView: RecyclerView,
        private var currentViewType: Int = -1
    ) : ViewRetriever {

        lateinit var currentViewHolder: RecyclerView.ViewHolder

        override fun getViewHolderForPosition(headerPosition: Int): RecyclerView.ViewHolder {
            val viewType = recyclerView.adapter?.getItemViewType(headerPosition)
            recyclerView.adapter?.let {
                if (currentViewType != viewType) {
                    currentViewType = viewType ?: -1
                    currentViewHolder =
                        it.createViewHolder(recyclerView.parent as ViewGroup, currentViewType)
                }
            }
            return currentViewHolder
        }
    }
}
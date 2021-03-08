package android.example.telegram.ui.fragments.single_chat

import android.example.telegram.R
import android.example.telegram.models.CommonModel
import android.example.telegram.utilits.CURRENT_UID
import android.example.telegram.utilits.DiffUtilCalback
import android.example.telegram.utilits.asTime
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_item.view.*

class SingleChatAdapter: RecyclerView.Adapter<SingleChatAdapter.SingleChatHolder>() {
    private var mListMessagesCache = emptyList<CommonModel>()
    private lateinit var mDiffResult: DiffUtil.DiffResult

    class SingleChatHolder(view: View): RecyclerView.ViewHolder(view) {

        val blocUserMessage: ConstraintLayout = view.block_user_message
        val chatUserMessage:TextView = view.chat_user_message
        val chatUserMessageTime:TextView = view.chat_user_message_time

        val blocReceivedMessage:ConstraintLayout = view.block_received_message
        val chatReceivedMessage:TextView = view.chat_received_message
        val chatReceivedMessageTime:TextView = view.chat_received_message_time
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleChatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
        return SingleChatHolder(view)
    }

    override fun onBindViewHolder(holder: SingleChatHolder, position: Int) {
        if (mListMessagesCache[position].from == CURRENT_UID) {
            holder.blocUserMessage.visibility = View.VISIBLE
            holder.blocReceivedMessage.visibility = View.GONE
            holder.chatUserMessage.text = mListMessagesCache[position].text
            holder.chatUserMessageTime.text = mListMessagesCache[position].timeStamp.toString().asTime()
        } else {
            holder.blocUserMessage.visibility = View.GONE
            holder.blocReceivedMessage.visibility = View.VISIBLE
            holder.chatReceivedMessage.text = mListMessagesCache[position].text
            holder.chatReceivedMessageTime.text = mListMessagesCache[position].timeStamp.toString().asTime()
        }
    }

    override fun getItemCount(): Int = mListMessagesCache.size

    fun addItem(item:CommonModel) {
        val newList = mutableListOf<CommonModel>()
        newList.addAll(mListMessagesCache)

        if (!newList.contains(item)) newList.add(item)

        newList.sortBy { it.timeStamp.toString() }
        mDiffResult = DiffUtil.calculateDiff(DiffUtilCalback(mListMessagesCache, newList))
        mDiffResult.dispatchUpdatesTo(this)
        mListMessagesCache = newList
    }
}



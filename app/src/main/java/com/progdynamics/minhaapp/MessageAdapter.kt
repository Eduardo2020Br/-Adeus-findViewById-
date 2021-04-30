package com.progdynamics.minhaapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// Ao solicitar a RecyclerView.Adapter abaixo foi importado a lib acima
// devo inserir a parametrização abaixo
class MessageAdapter :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    // clicar sobre a class acima e a IDE sugere criar membros que foram criados abaixo

    // lista de mensagens
    private val itens: MutableList<String> = mutableListOf ()
    fun addItem(message:String){
        itens.add(message)
        notifyDataSetChanged()
    }
    // o método get informa a recycler sobre as Views
    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // no momento de criação teremos uma referencia
        val card = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.message_card,parent, false)
        return MessageViewHolder(card)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = itens[position] // SmartCast do Kotlin
        if (holder is MessageViewHolder) {
            holder.messageTextView.text = currentItem
        }

    }
    // o construtor recebe uma variavel View que sera repassada para o RecyclerView
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val messageTextView: TextView = itemView.findViewById(R.id.message_textView)
    }


}
package com.progdynamics.minhaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // vamos conseguir fazer o codigo abaixo devido id 'kotlin-android-extensions'
        // colocado no build.gradle (Módule app)

        setUpListeners()
        setUpRecyclerView()

    }

    private fun setUpListeners() {
        send_button.setOnClickListener {
            // segue código associado ao botão
            val message = message_edittext.text.toString() //capto o texto
            message_edittext.setText("") // apago a entrada de dados
            //message_textview.text = message // então posso atribuir a val para expor
            val adapter = message_list.adapter
            if (adapter is MessageAdapter) {
                adapter.addItem(message)
                message_list.scrollToPosition(adapter.itemCount-1)
            }

        }
    }
    private fun setUpRecyclerView(){
        // configuração da RecyclerView vamos precisar de LAYOUTMANAGER e um ADAPTER
        message_list.layoutManager = LinearLayoutManager(this) // Linear <=> Lista Vertical a de cima pra baixo
        message_list.adapter = MessageAdapter()
    }
}
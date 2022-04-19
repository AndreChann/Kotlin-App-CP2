package br.com.pedrosantos.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.pedrosantos.myapp.model.Food

class MainActivity : AppCompatActivity() {

    private lateinit var foodlist:MutableList<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exitTv:TextView = findViewById(R.id.exitTv)
        val etFoodName:TextView = findViewById(R.id.etFoodName)
        val etFoodFlavor:TextView = findViewById(R.id.etFoodFlavor)
        val etFoodPrice:TextView = findViewById(R.id.etFoodPrice)
        val addButton:TextView = findViewById(R.id.addButton)

        addButton.setOnClickListener{
            registerItem(etFoodName.text.toString(),
                etFoodFlavor.text.toString(),
                etFoodPrice.text.toString())

            refreshScreen(exitTv)
            etFoodName.text=""
            etFoodFlavor.text=""
            etFoodPrice.text=""
        }
        foodlist = mutableListOf()
    }

    fun refreshScreen(exit:TextView){
        exit.text=""
        foodlist.forEach {
            val text = "${exit.text} ${it.name} - ${it.Flavor} - ${it.price} \n"
            exit.text = text
        }
    }

    fun registerItem(name:String, flavor:String, price:String){
        foodlist.add(Food(name = name, Flavor = flavor, price = price.toDouble()))
    }
}
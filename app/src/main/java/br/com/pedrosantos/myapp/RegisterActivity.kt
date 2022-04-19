package br.com.pedrosantos.myapp

import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.pedrosantos.myapp.model.Food

class RegisterActivity : AppCompatActivity() {

    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFoodName:TextView = findViewById(R.id.etFoodName)
        val etFoodFlavor:TextView = findViewById(R.id.etFoodFlavor)
        val etFoodPrice:TextView = findViewById(R.id.etFoodPrice)

        val addButton:TextView = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            registerItem(etFoodName.text.toString(),
                etFoodFlavor.text.toString(),
                etFoodPrice.text.toString())

            etFoodName.text=""
            etFoodFlavor.text=""
            etFoodPrice.text=""

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }

    fun registerItem(name:String, flavor:String, price:String){
        Database.foodList.add(Food(name = name, Flavor = flavor, price = price.toDouble()))
    }
}

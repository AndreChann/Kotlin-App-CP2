package br.com.pedrosantos.myapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.pedrosantos.myapp.model.Food

class ViewActivity : AppCompatActivity() {

    private lateinit var foodSelected:Food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        foodSelected = intent.getSerializableExtra("data") as Food

        val tvPizzaName: TextView = findViewById(R.id.tvPizzaName)
        val tvPizzaFlavor: TextView = findViewById(R.id.tvPizzaFlavor)
        val tvPizzaPrice: TextView = findViewById(R.id.tvPizzaPrice)

        tvPizzaName.text = foodSelected.name
        tvPizzaFlavor.text = foodSelected.Flavor
        tvPizzaPrice.text = foodSelected.price.toString()
    }
}
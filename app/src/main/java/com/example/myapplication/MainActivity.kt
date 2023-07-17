package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //print data or starting message
        val atNoDataText = findViewById<TextView>(R.id.noDataText)
        val atTotalCategoriesInfo = findViewById<TextView>(R.id.totalCategoriesInfo)
        val atTotalExpensesInfo = findViewById<TextView>(R.id.totalExpensesInfo)
        if(Data.allData.size == 0){
            atNoDataText.setText(Data.printNoData())
        }
        else{
            atTotalCategoriesInfo.setText(Data.printAllCategories())
            atTotalExpensesInfo.setText(Data.printAllExpenses())
        }

        //budget message
        val atBudgetText = findViewById<TextView>(R.id.budgetText)
        atBudgetText.setText(Data.printBudgetDetails())


        //the two buttons
        val toExpensesButton = findViewById<Button>(R.id.updateexpensesbutton)
        toExpensesButton.setOnClickListener{
            val intent = Intent(this, Expenses::class.java)
            startActivity(intent)
        }

        val toBudgetButton = findViewById<Button>(R.id.updatebudgetbutton)
        toBudgetButton.setOnClickListener{
            val intent = Intent(this, BudgetActivity::class.java)
            startActivity(intent)
        }

        //catch category intent (Not using this intent anymore but keeping if needed for future)
        //val intentTotalInfo = intent
        //val getTotalInfo = intentTotalInfo.getStringExtra("allTheInfo")
        //atTotalInfo.setText(getTotalInfo)


    }
}
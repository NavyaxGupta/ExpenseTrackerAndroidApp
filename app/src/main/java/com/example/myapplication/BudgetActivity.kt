package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class BudgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)


        val recordUpdate = findViewById<Button>(R.id.updateBudgetButtonB)
        recordUpdate.setOnClickListener{

            //collect all values after the click of button
            val nameOfCategory = findViewById<EditText>(R.id.enteredName)
            val amountOfBudget = findViewById<EditText>(R.id.enteredBudget)
            val stringNameOfCategory = nameOfCategory.text.toString()
            val intCountOfExpense = amountOfBudget.text.toString().toInt()

            // go through Data.allData and update budget
            for (x in Data.allData) {
                if (x.getType() == stringNameOfCategory) {
                    x.limit = intCountOfExpense
                    break
                }
            }

            //intent to return to home page
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        val goBack = findViewById<Button>(R.id.goBackButton)
        goBack.setOnClickListener{
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

        }
    }
}
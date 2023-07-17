package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class Expenses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)


        val recordUpdate = findViewById<Button>(R.id.updateCategoryButton)
        recordUpdate.setOnClickListener{

            //collect all values after the click of button
            val nameOfCategory = findViewById<EditText>(R.id.enteredName)
            val countOfExpense = findViewById<EditText>(R.id.enteredExpense)
            val stringNameOfCategory = nameOfCategory.text.toString()
            val intCountOfExpense = countOfExpense.text.toString().toIntOrNull()

            //If Category does not exist, add it to Data.allData and Data.allTypes
            if (!Data.allTypes.contains(stringNameOfCategory)) {
                // Create new category named nameOfNewCategoryToBeCreated. And add that category to data.allData
                val x = Category(stringNameOfCategory)
                Data.allData.add(x)
                Data.allTypes.add(x.getType())
            }

            // go through Data.allData and update expenses
            for (x in Data.allData) {
                if (x.getType() == stringNameOfCategory) {
                    x.addExpense(intCountOfExpense ?: 0)
                    break
                }
            }

            //intent to return to home page
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            //pass data to main and move screen to main
            //val intent1 = Intent(this, MainActivity::class.java)
            //intent1.putExtra("allTheInfo", Data.printAllData() );
            //startActivity(intent1)

        }

        val goBack = findViewById<Button>(R.id.goBackButton)
        goBack.setOnClickListener{
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

        }
    }
}
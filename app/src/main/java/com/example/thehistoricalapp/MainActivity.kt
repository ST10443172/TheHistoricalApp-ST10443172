package com.example.thehistoricalapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // list of Historical Events along with the years
    enum class HistoricalEvent(val year: Int, val description: String) {
        EVENT_1(95, " You are 95 years old, as Nelson Maandela. Nelson Rolihlahla Mandela was a South African anti-apartheid activist, politician, and statesman who served as the first president of South Africa from 1994 to 1999."),
        EVENT_2(62, " You are 62 years old, as Francis Nkrumah. Francis Kwame Nkrumah was a Ghanaian politician, political theorist, and revolutionary. He served as Prime Minister of the Gold Coast from 1952 until 1957, when it gained independence from Britain."),
        EVENT_3(37, " You are 37 years old, as Thomas Sankara. Thomas Isidore Noël Sankara was a Burkinabè military officer, Marxist revolutionary and Pan-Africanist who served as President of Burkina Faso from his coup in 1983 to his assassination in 1987."),
        EVENT_4(74, " You are 74 years old, as Idi Oumee.Idi Amin Dada Oumee was a Ugandan military officer and politician who served as the third president of Uganda from 1971 to 1979."),
        EVENT_5(77, " You are 77 years old, as Amina. Amina was a Hausa historical figure in the city-state Zazzau, in what is now in the north-west region of Nigeria. She might have ruled in the mid-sixteenth century."),
        EVENT_6(79, " You are 79 years old, as Eduardo dos Santos. José Eduardo dos Santos was the president of Angola from 1979 to 2017. As president, dos Santos was also the commander-in-chief of the Angolan Armed Forces and president of the People's Movement for the Liberation of Angola, the party that has ruled Angola since it won independence in 1975."),
        EVENT_7(67, " You are 67 years old ,as Jonas Savimbi. Jonas Malheiro Savimbi was an Angolan revolutionary, politician, and rebel military leader who founded and led the National Union for the Total Independence of Angola. UNITA was one of several groups which waged a guerrilla war against Portuguese colonial rule from 1966 to 1974."),
        EVENT_8(83, " You are 83 years old ,as Haile Selassie. Haile Selassie was the Emperor of Ethiopia from 1930 to 1974. He rose to power as Regent Plenipotentiary of Ethiopia for Empress Zewditu from 1916 until 1930."),
        EVENT_9(35, " You are 35 years old ,as Isaïe Tawosa,Isaïe Tasumbu Tawosa was a Congolese politician and independence leader who served as the first prime minister of the Democratic Republic of the Congo from June until September 1960, following the May 1960 election. "),
        EVENT_10(71, " 95You are 71 years old ,as Dedan  Waciuri. Dedan Kimathi Waciuriwas the senior military and spiritual leader of the Kikuyu rebels involved in the Mau Mau Uprising. Widely regarded as a revolutionary leader, he led the armed military struggle against the British colonial regime in Kenya in the 1950s until his capture in 1956 and execution in 1957. "),
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // getting layout components
        val userYear = findViewById<EditText>(R.id.editTextNumber)
        val displayResult = findViewById<Button>(R.id.button)
        val clearApp = findViewById<Button>(R.id.button2)
        val txtResult = findViewById<TextView>(R.id.textView)

        displayResult.setOnClickListener {
            val AgeString = userYear.text.toString()
            val age = AgeString.toIntOrNull()
            if (age == null || age !in 25..105) {
                txtResult.text = "Please enter a valid year between 25 and 105."
                return@setOnClickListener
            }
            // grabbing the values of the years in the list of Historical events
            val events = HistoricalEvent.values().filter { it.year == age }.map { " $age: ${it.description}" }
            txtResult.text = if (events.isNotEmpty()) events.joinToString() else "No historical events found for $age."
        }
        // if user presses the clear button
        clearApp.setOnClickListener {
            userYear.text.clear()
            txtResult.text = "Event"
        }
    }
}



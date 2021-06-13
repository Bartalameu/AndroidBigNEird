package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.add_crime.*
import kotlinx.android.synthetic.main.add_crime.view.*

class AddCrimeFragment : Fragment() {
    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProviders.of(this).get(CrimeListViewModel::class.java)

    }


    companion object {
        fun newInstance(): AddCrimeFragment {
            return AddCrimeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_crime, container, false)

        view.add_crime.setOnClickListener {
            val crime= Crime()
            val title = view.crime_title.text.toString()
            val solved=view.crime_solved.isChecked
            crime.title=title
            crime.isSolved=true
            crime.isSolved=solved
            add_crime(crime)

            view.crime_title.text.clear()

        }

        view.wipew_data.setOnClickListener{
            CrimeRepository.get().wipeData()
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun add_crime(crime: Crime) {
        CrimeRepository.get().addCrime(crime)

    }



}
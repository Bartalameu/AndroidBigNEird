package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.room.RoomDatabase

class CrimeListViewModel () : ViewModel() {


    private val crimeRepository = CrimeRepository.get()

    val crimeListLiveData = crimeRepository.getCrimes()


}
package com.acevedo.horoscapp.ui.providers

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest{
    @Test
    fun `getRandomCard should return a random card`() {
        //Given - infomacion necesaria para el test
        val randomCard = RandomCardProvider()

        //When - cuando algo ocurra
        val card = randomCard.getLucky()

        //Then - verificamos que paso algo
        assertNotNull(card) //aseguramos que esto no es nulo
    }
}
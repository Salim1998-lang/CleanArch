package com.example.holybibleapp.core

import junit.framework.TestCase.assertTrue
import org.junit.Test

class AbstractTest {

    @Test
    fun test_success() {
        val dataObject = TestDataObject.Success("a", "b")
        val domainObject = dataObject.map(DataToDomainMapper.Base())
        assertTrue(domainObject is DomainObject.Success)
    }

    @Test
    fun test_fail() {
        val dataObject = TestDataObject.Success("a", "b")
        val domainObject = dataObject.map(DataToDomainMapper.Base())
        assertTrue(domainObject is DomainObject.Success)
    }

    private sealed class TestDataObject : Abstract.Object<DomainObject, DataToDomainMapper> {
        abstract override fun map(mapper: DataToDomainMapper): DomainObject

        class Success(private val textOne: String, private val textTwo: String) : TestDataObject() {
            override fun map(mapper: DataToDomainMapper): DomainObject {
                return mapper.map(textOne, textTwo)
            }
        }

        class Fail(private val exception: Exception) : TestDataObject() {
            override fun map(mapper: DataToDomainMapper): DomainObject {
                return mapper.map(exception)
            }
        }
    }

    private interface DataToDomainMapper : Abstract.Mapper {
        fun map(textOne: String, textTwo: String): DomainObject

        fun map(exception: Exception): DomainObject

        class Base : DataToDomainMapper{
            override fun map(textOne: String, textTwo: String): DomainObject {
                return DomainObject.Success("$textOne $textTwo")
            }

            override fun map(exception: Exception): DomainObject {
                return DomainObject.Fail()
            }

        }

    }

    private sealed class DomainObject : Abstract.Object<UIObject, DomainToUIMapper> {
         class Success(private val textCombined: String) : DomainObject() {
             override fun map(mapper: DomainToUIMapper): UIObject {
                 TODO("Not yet implemented")
             }
         }

        class Fail: DomainObject() {
            override fun map(mapper: DomainToUIMapper): UIObject {
                TODO("Not yet implemented")
            }

        }
    }

    private interface DomainToUIMapper: Abstract.Mapper

    private sealed class UIObject

}
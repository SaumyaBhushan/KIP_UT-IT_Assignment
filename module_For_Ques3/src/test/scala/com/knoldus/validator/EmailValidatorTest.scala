package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {

  val emailValidator:EmailValidator=new EmailValidator()

  behavior of "This Email"
  it should "be valid as it is written in correct format" in{
    val email="Saumya123@gmail.com"
    assert(emailValidator.emailIdIsValid(email))
  }

  it should "not valid as it contains blank space" in{
    val email="saumya 112@gmail.com.net" // blank space not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid as it contains two or more dot symbols" in{
    val email= "saumya@gmail..com" // two dots are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid as it does not contain @ symbol" in{
    val email= "Saumya.com" // here @ symbol is missing.
    assert(!emailValidator.emailIdIsValid(email))
  }


}

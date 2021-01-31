package com.knoldus.validator

import com.knoldus.models.Email
import com.knoldus.validators.EmailValidator
import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec{

  val emailValidator:EmailValidator=new EmailValidator()

  "This Email" should "be valid as it is written in correct format" in{

    val email:Email=new Email("Saumya123@gmail.com")
    assert(emailValidator.isEmailValid(email))
  }

  it should "not be valid as it contains blank space" in{

    val email:Email=new Email("Saumya 123@gmail.com.net") // blank space not allowed.
    assert(!emailValidator.isEmailValid(email))
  }

  it should "also not valid as it contains two or more dot symbols" in{

    val email:Email=new Email("Saumya123@gmail..com") // two dots are not allowed.
    assert(!emailValidator.isEmailValid(email))
  }

  it should "also not valid as it does not contain @ symbol" in{

    val email:Email=new Email("Saumya.com") // here @ symbol is missing.
    assert(!emailValidator.isEmailValid(email))
  }


}

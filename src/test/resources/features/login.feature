Feature: Login SauceDemo

  Scenario: Positive - login berhasil dengan kredensial valid
    Given saya membuka halaman login
    When saya login dengan username "standard_user" dan password "secret_sauce"
    Then saya berhasil masuk ke halaman inventory

  Scenario: Negative - login gagal dengan password salah
    Given saya membuka halaman login
    When saya login dengan username "standard_user" dan password "salah_password"
    Then muncul error message yang mengandung "Username and password do not match"

  Scenario: Boundary - username kosong
    Given saya membuka halaman login
    When saya login dengan username "" dan password "secret_sauce"
    Then muncul error message yang mengandung "Username is required"

  Scenario: Boundary - username sangat panjang
    Given saya membuka halaman login
    When saya login dengan username "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" dan password "secret_sauce"
    Then muncul error message yang mengandung "Username and password do not match"

## Web Automation Framework — SauceDemo 
Framework ini dirancang untuk melakukan pengujian otomatis antarmuka pengguna web menggunakan Cucumber + Selenium + Java , dikelola dengan Gradle , serta menerapkan Page Object Model (POM) untuk menjaga keteraturan dan kemudahan perawatan kode . 
Website yang diuji: https://www. sausdemo. com/ 

## Technology Stack 
- Java 21 
- Gradle 
- Selenium WebDriver 
- Cucumber (BDD / Gherkin) 
- JUnit Platform 
- WebDriverManager 
- AssertJ 
- Google Chrome 

## Project Structure
ini bagian menjadi beberapa paket utama agar kode lebih mudah dipahami dan dikelola : 
**pages** 
Berisi Page Object Model untuk setiap halaman di situs web 
(contoh: LoginPage, InventoryPage) 
**pages** 
Berisi implementasi Step Definition Cucumber 
(menghubungkan Gherkin dengan Selenium) 
**runner** 
Digunakan untuk menjalankan Cucumber lewat JUnit Platform 
**runner**
Berisi file `. feature` yang ditulis dalam bahasa Gherkin 

Struktur ini membantu menjaga kode tetap terorganisir , terstruktur, dan mengikuti praktik terbaik di industri. 

## Page Object Model (POM) 

Framework ini menggunakan **Page Object Model**:
- LoginPage. java 
Mengelola semua elemen dan tindakan di halaman login 
- InventoryPage. java 
mendukung verifikasi halaman inventaris setelah proses login 
Tujuan: 
- menambahkan pengulangan kode 
- Kode lebih teratur 
- Mempermudah pemeliharaan
  
## Test Scenarios (Gherkin)
Semua test ditulis menggunakan **bahasa Gherkin** (Cucumber).

### Positive Test
- Masuk dengan username dan password yang benar
- Berhasil menuju halaman inventory 
### Negative Test
- Masuk dengan password yang salah 
- Masuk dengan pengguna yang tidak ada 
### Boundary Test
- Masuk dengan username kosong 
- Masuk dengan username yang sangat panjang
  
Contoh di `login. feature`: 
gherkin 
Feature: Login SauceDemo 

Scenario: Positive - login sukses dengan kredensial yang valid 
Given saya mengakses halaman login 
When saya melakukan login menggunakan username "standard_user" dan password "secret_sauce" 
Then saya berhasil menuju halaman inventory 

Scenario: Negative - login gagal dengan password salah 
Given saya mengakses halaman login 
When saya melakukan login menggunakan username "standard_user" dan password "salah" 
Then muncul pesan kesalahan yang mengandung "Epic sadface" 

Scenario: Boundary - username kosong 
Given saya mengakses halaman login 
When saya melakukan login dengan username "" dan password "secret_sauce" 
Then muncul pesan kesalahan yang mengandung "Username is required" 


## Cara Menjalankan Uji 
**Jalankan lewat Terminal** 
Windows PowerShell: 
. gradlew. bat clean test 

Mac / Linux: 
. /gradlew clean test 

## Laporan Uji 
**Cucumber Report** 
build/reports/cucumber. html 

**Gradle HTML Report**
build/reports/tests/test/index. html 

Buka file ini di browser untuk melihat hasil uji. 

## Konfigurasi 
**File konfigurasi Cucumber:** 
src/test/resources/junit-platform. properties 
cucumber. glue=com. bagas. ui. steps 
cucumber. plugin=pretty, html:build/reports/cucumber. html, json:build/reports/cucumber. json 

**Penulis** 
Bagas Arrayyan 
GitHub: https://github. com/mbagasarrayyan-art 

**Catatan** 
Kerangka kerja ini dibuat untuk PR 19 Modul 21 
Telah memenuhi: 
- Uji Positif 
- Uji Negatif 
- Uji Batas 
- Browser otomatis menggunakan Selenium 
- Laporan otomatis

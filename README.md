# android-developer-coding-test
Aplikasi android untuk menampilkan resep makanan.

Aplikasi menggunakan Retrofit2 untuk menghubungkan aplikasi dengan API recipes.json.
Retrofit2 dipilih dikarenakan memiliki sintax yang sederhana dan bekerja secara cepat.

Resep makanan ditampilkan dalam bentuk _Cardview_ yang memuat gambar dan informasi gizi makanan.

## testing
Aplikasi membutuhkan koneksi internet agar dapat menampilkan data resep.

Pengujian pertama dilakukan dengan menjalankan aplikasi dengan kondisi perangkat _online_.
* Aplikasi lolos pengujian pertama apabila dapat menampilkan resep makanan.
* Aplikasi gagal pengujian pertama apabila tidak dapat menampilkan resep makanan.

Pengujian kedua dilakukan dengan menjalankan aplikasi dengan kondisi perangkat _offline_.

Alur pengujian kedua :
* Jalankan aplikasi dengan status perangkat _offline_.
* Cek apakah aplikasi menampilkan resep.          --> Jika aplikasi menampilkan pesan error dan perintah _refresh page_, lanjutkan pengujian.
* Sambungkan perangkat ke internet.
* _Swipe down_ halaman aplikasi.
* Cek apakah aplikasi menampilkan resep.          --> Jika aplikasi menampilkan resep, aplikasi lolos pengujian kedua.

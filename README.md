## TP12: Sprint #5 — Layout, UI Responsif & Panel Bersarang (v0.5)

### 1. Wireframe Layout MainWindow v0.5
Rancangan tata letak antarmuka **Character Manager v0.5** menggunakan arsitektur panel bersarang (*nested panels*) dengan `BorderLayout` sebagai kerangka utama pada `JFrame`:

```text
+-----------------------------------------------------------------------+ [NORTH]
| Character Manager                                        8 karakter   |
+-----------------------------------------------------------------------+ [CENTER]
| +-----------------------------------------+ +-----------------------+ |
| | Arjuna | WARRIOR | Lv.5 | HP:150 | ATK:35| | Legenda Role          | |
| +-----------------------------------------+ | [WARRIOR]             | |
| | Merlin | MAGE | Lv.3 | HP:130 | ATK:25   | | [MAGE]                | |
| +-----------------------------------------+ | [ARCHER]              | |
| | Athena | ARCHER | Lv.4 | HP:140 | ATK:30 | | [HEALER]              | |
| +-----------------------------------------+ |                       | |
| | (JScrollPane: vertikal scroll aktif)    | |                       | |
| +-----------------------------------------+ +-----------------------+ |
+-----------------------------------------------------------------------+ [SOUTH]
| Total: 8 karakter  |  Avg Level: 4.5  |  Siap                    v0.5 |
+-----------------------------------------------------------------------+

2. Penjelasan Struktur Panel Bersarang (Nested Panels)
Aplikasi ini membagi layar menjadi empat wilayah fungsional di dalam content pane JFrame yang ber-BorderLayout:
 * Wilayah NORTH (Header): Menggunakan JPanel dengan BorderLayout untuk menempatkan judul aplikasi di sisi kiri (WEST) dan penghitung jumlah karakter di sisi kanan (EAST).
 * Wilayah CENTER (Daftar Karakter Berscroll): Menggunakan JScrollPane yang membungkus panel holder (BorderLayout), di mana daftar kartu ber-GridLayout(0, 1) ditaruh di posisi NORTH holder agar tinggi setiap kartu tetap alami (tidak ikut melar saat jendela ditinggikan).
 * Wilayah EAST (Legenda Role): Menggunakan JPanel dengan BoxLayout vertikal (Y_AXIS), dilengkapi Box.createVerticalStrut() sebagai jarak antar-chip role dan Box.createVerticalGlue() di bagian bawah untuk mendorong seluruh elemen menempel ke atas.
 * Wilayah SOUTH (Bar Status & Mini-Challenge): Menggunakan JPanel dengan BorderLayout agar teks informasi total karakter dan rata-rata level menempel di kiri (WEST), sedangkan label versi "v0.5" menempel di kanan (EAST).
3. Alasan Pemilihan Layout Panel Tambahan & Layout yang Ditolak
 * Panel Tambahan / Perluasan Status Bar (BorderLayout): Untuk memenuhi Mini-Challenge serta menampilkan ringkasan statistik rata-rata level (Avg Level: 4.5) bersama versi aplikasi "v0.5", bar status diubah dari FlowLayout menjadi BorderLayout. Layout ini dipilih karena mampu memisahkan dua kelompok informasi ke dua kutub berlawanan (WEST dan EAST) dengan jarak tengah yang fleksibel saat jendela dilebarkan.
 * Layout yang Ditolak (FlowLayout & GridLayout): FlowLayout ditolak karena akan membuat teks status dan label versi saling berdempetan di tengah atau rata kiri saja tanpa jarak proporsional ke tepi kanan. GridLayout(1, 2) juga ditolak karena akan membagi ruang bar status menjadi dua kolom kaku berukuran 50:50 sehingga teks status yang panjang berisiko terpotong.
4. Tabel Pengamatan Uji Resize (Resize Observation Table)
| Tindakan | Prediksi dari Teori | Catatan Hasil Nyata |
|---|---|---|
| Lebarkan Jendela | Hanya area CENTER (JScrollPane) yang melebar secara horizontal; lebar EAST tetap, sedangkan NORTH dan SOUTH melebar tanpa mengubah ukuran teks di dalamnya. | Sesuai prediksi: Daftar kartu karakter melebar mengikuti jendela, sementara legenda di kanan tetap proporsional dan label v0.5 tetap menempel di pojok kanan bawah. |
| Tinggikan Jendela | Area CENTER bertambah tinggi; kartu-kartu di dalam GridLayout tidak ikut melar vertikal karena diletakkan pada BorderLayout.NORTH di dalam panel holder. | Sesuai prediksi: Ruang kosong di bawah daftar kartu terisi latar gelap dengan rapi dan tinggi tiap kartu tetap konsisten. |
| Kecilkan Tinggi | Tinggi area daftar menyusut di bawah tinggi total 8 kartu (280 px), sehingga scrollbar vertikal otomatis muncul di sisi kanan daftar. | Sesuai prediksi: Scrollbar vertikal aktif dan daftar 8 karakter dapat digulir dengan mulus tanpa memotong header maupun status bar. |
| Sempitkan Sampai Batas | Jendela berhenti mengecil pada ukuran minimum 560x380 piksel berkat pengaturan setMinimumSize(). | Sesuai prediksi: Jendela tertahan pada batas minimum sehingga komponen tidak bertumpuk (overlapping). |
5. Bukti Screenshot Antarmuka (v0.5)
 * Ukuran Awal (Initial State - saat program pertama kali dijalankan):Screenshoot Tp 12 ukuran awal.png
   
 * Jendela Dilebarkan (Expanded State - seluruh 8 karakter tampak tanpa scroll):Screenshot TP12 ukuran dilebarkan.png
   
 * Jendela Dikecilkan (Scrollbar Active - scrollbar vertikal muncul):Screenshot TP12 ukuran dikecilkan.png
   
6. Analisis Layout & MVC (Bagian D)
 * Dokumen Analisis Google Docs: https://docs.google.com/document/d/1z3ZErBpjOrQUEDWhkv2dzEQMitFYZ537iH82SqM-G2M/edit?usp=sharing

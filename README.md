# 🧮 Kalkulator Bangun Ruang & Datar

<div align="center">

![Java Version](https://img.shields.io/badge/java-8%2B-orange)
![License](https://img.shields.io/badge/license-MIT-green)
![Status](https://img.shields.io/badge/status-active-success)
![GUI](https://img.shields.io/badge/GUI-Swing-blue)

**Kalkulator geometri lengkap dengan GUI modern - TANPA LIBRARY EXTERNAL!**

[Fitur](#-fitur) • [Instalasi](#-instalasi) • [Penggunaan](#-penggunaan) • [Dokumentasi](#-dokumentasi)


</div>

## 📋 Daftar Isi

- [Gambaran Umum](#-gambaran-umum)
- [Fitur](#-fitur)
- [Instalasi](#-instalasi)
- [Penggunaan](#-penggunaan)
- [Dokumentasi](#-dokumentasi)
- [Struktur Project](#-struktur-project)
- [Bangun Ruang & Datar](#-bangun-ruang--datar)
- [Contoh Penggunaan](#-contoh-penggunaan)
- [Troubleshooting](#-troubleshooting)
- [FAQ](#-faq)

## 🚀 Gambaran Umum

**Kalkulator Bangun Ruang & Datar** adalah aplikasi kalkulator geometri komprehensif yang dibangun dengan **pure Java Swing**. Keunggulan utama: **TIDAK PERLU LIBRARY EXTERNAL** - 100% Java Standard Edition!

### ✨ Highlights

- 🎨 **GUI Modern** dengan navigasi card-based
- 📊 **9 Jenis Bangun** - 5 bangun ruang + 4 bangun datar
- 💾 **Sistem History** dengan penyimpanan file text
- 🚀 **Zero Dependencies** - Tidak butuh library external
- 📈 **Statistik Real-time** perhitungan
- 🧮 **Input Dinamis** yang menyesuaikan bangun
- ✅ **Validasi Input** yang robust
- 🔧 **Easy Setup** - Download dan langsung jalan!

## 🌟 Fitur

### 🧮 Core Features
- **Perhitungan Akurat** - Menggunakan rumus matematika standar
- **Multiple Kategori** - Bangun ruang dan bangun datar terpisah
- **Rumus Otomatis** - Menampilkan rumus yang digunakan
- **Validasi Input** - Mencegah kesalahan input pengguna

### 📦 Bangun Ruang yang Didukung
1. **Balok** - Volume = p × l × t
2. **Kubus** - Volume = s³  
3. **Bola** - Volume = 4/3 × π × r³
4. **Tabung** - Volume = π × r² × t + Luas Permukaan
5. **Kerucut** - Volume = 1/3 × π × r² × t

### 📐 Bangun Datar yang Didukung
1. **Persegi Panjang** - Luas = p × l, Keliling = 2×(p+l)
2. **Trapesium** - Luas = ½ × (a+b) × t
3. **Segitiga** - Luas = ½ × a × t
4. **Lingkaran** - Luas = π × r², Keliling = 2×π×r

### 💾 Data Management
- **Auto-save History** - Setiap perhitungan langsung tersimpan
- **Text File Storage** - Format penyimpanan simpel
- **Riwayat Lengkap** - Detail perhitungan, rumus, dan waktu
- **Hapus History** - Fitur bersihkan riwayat

### 🎨 GUI Features
- **CardLayout Navigation** - Navigasi antar panel yang smooth
- **Dynamic Input Forms** - Form input menyesuaikan bangun
- **Professional Layout** - Desain yang rapi dan intuitif
- **Responsive Design** - Tampilan adaptif berbagai resolusi

## 📥 Instalasi

### Prerequisites

- **Java 8** atau lebih tinggi
- **Windows/Linux/Mac** OS
- **Tidak perlu internet** setelah download

### 🚀 Quick Installation (Recommended)

1. **Download Project**
   ```bash
   # Download ZIP atau clone repository
   git clone https://github.com/username/super-geometry-calculator.git
   cd super-geometry-calculator
   ```

2. **Jalankan Aplikasi**
   - **Windows**: Double click `compile_and_run.bat`
   - **Linux/Mac**: 
     ```bash
     chmod +x compile_and_run.sh
     ./compile_and_run.sh
     ```

### Manual Installation (Untuk Development)

1. **Compile Manual**
   ```bash
   # Windows
   javac -d bin src/*.java src/model/**/*.java src/database/*.java src/gui/*.java
   java -cp bin src.Main
   
   # Linux/Mac
   javac -d bin src/*.java src/model/**/*.java src/database/*.java src/gui/*.java
   java -cp bin src.Main
   ```

### ✅ Verifikasi Instalasi

Jika muncul GUI dengan judul "Kalkulator Bangun Ruang & Datar", instalasi berhasil!

## 🎮 Penggunaan

### Menjalankan Aplikasi

```bash
# Cara termudah - double click file batch
compile_and_run.bat
```

### Basic Usage

1. **Memilih Kategori**
   - Pilih "Bangun Ruang" untuk menghitung volume
   - Pilih "Bangun Datar" untuk menghitung luas & keliling

2. **Memilih Bangun**
   - Pilih bangun yang ingin dihitung dari dropdown
   - Form input akan menyesuaikan otomatis

3. **Input Dimensi**
   - Masukkan nilai dimensi yang diperlukan
   - Gunakan titik (.) untuk desimal
   - Contoh: `5.5`, `10.25`, `7.0`

4. **Hitung & Lihat Hasil**
   - Klik tombol "Hitung"
   - Hasil akan ditampilkan di text area
   - History otomatis tersimpan

### Contoh Input

#### 🏗️ Bangun Ruang
**Balok:**
```
Panjang: 5.0
Lebar: 3.0
Tinggi: 2.0
```

**Tabung:**
```
Jari-jari: 3.5
Tinggi: 10.0
```

#### 📐 Bangun Datar
**Persegi Panjang:**
```
Panjang: 15.0
Lebar: 5.0
```

**Lingkaran:**
```
Jari-jari: 5.0
```

### Navigasi

- **Menu Navigasi** → "Kalkulator" untuk kembali ke kalkulator
- **Menu Navigasi** → "History" untuk melihat riwayat
- **Tombol Hapus** di panel History untuk clear data

## 📚 Dokumentasi

### Architecture Overview

```
Kalkulator Bangun Ruang & Datar
├── Presentation Layer (GUI)
│   ├── MainFrame - Window utama dengan CardLayout
│   ├── CalculatorPanel - Panel input dan hasil
│   └── HistoryPanel - Panel history
├── Business Logic Layer (Model)
│   ├── BangunRuang (Abstract) - Base class bangun ruang
│   ├── BangunDatar (Abstract) - Base class bangun datar
│   ├── 5 Concrete BangunRuang classes
│   └── 4 Concrete BangunDatar classes
├── Data Access Layer (Database)
│   └── HistoryManager - Text file management
└── Main Class - Application entry point
```

### Workflow

```mermaid
graph TD
    A[User Pilih Kategori] --> B[User Pilih Bangun]
    B --> C[Render Input Form]
    C --> D[User Input Data]
    D --> E{Validasi Input}
    E -->|Valid| F[Hitung Volume/Luas]
    E -->|Invalid| G[Tampilkan Error]
    F --> H[Simpan ke History]
    H --> I[Tampilkan Hasil]
    I --> J[Update UI]
```

## 🗂️ Struktur Project

```
super-geometry-calculator/
│
├── src/                             # Source code aplikasi
│   ├── Main.java                    # Entry point aplikasi
│   │
│   ├── model/                       # Business logic models
│   │   ├── bangun_ruang/            # 3D shape classes
│   │   │   ├── BangunRuang.java     # Abstract base class
│   │   │   ├── Balok.java           # Rectangular prism volume
│   │   │   ├── Kubus.java           # Cube volume
│   │   │   ├── Bola.java            # Sphere volume
│   │   │   ├── Tabung.java          # Cylinder volume + surface area
│   │   │   └── Kerucut.java         # Cone volume
│   │   │
│   │   └── bangun_datar/            # 2D shape classes
│   │       ├── BangunDatar.java     # Abstract base class
│   │       ├── PersegiPanjang.java  # Rectangle area & perimeter
│   │       ├── Trapesium.java       # Trapezoid area
│   │       ├── Segitiga.java        # Triangle area
│   │       └── Lingkaran.java       # Circle area & circumference
│   │
│   ├── database/                    # Data management layer
│   │   └── HistoryManager.java      # History storage system
│   │
│   └── gui/                         # User interface layer
│       ├── MainFrame.java           # Main application window
│       ├── CalculatorPanel.java     # Calculator interface
│       └── HistoryPanel.java        # History management interface
│
├── history.txt                      # Auto-generated calculation history
├── LICENSE                          # MIT License file
└── README.md                        # Project documentation
```

## 📦 Bangun Ruang & Datar

### 🏗️ Bangun Ruang (Volume)

#### 1. Balok
- **Volume**: `p × l × t`
- **Input**: Panjang, Lebar, Tinggi
- **Rumus Display**: `p × l × t = [value] × [value] × [value]`

#### 2. Kubus
- **Volume**: `s³`
- **Input**: Sisi
- **Rumus Display**: `s³ = [value]³`

#### 3. Bola
- **Volume**: `4/3 × π × r³`
- **Input**: Jari-jari
- **Rumus Display**: `4/3 × π × r³ = 4/3 × 3.14 × [value]³`

#### 4. Tabung
- **Volume**: `π × r² × t`
- **Luas Permukaan**: `2 × π × r × (r + t)`
- **Input**: Jari-jari, Tinggi
- **Rumus Display**: `π × r² × t = 3.14 × [value]² × [value]`

#### 5. Kerucut
- **Volume**: `1/3 × π × r² × t`
- **Input**: Jari-jari, Tinggi
- **Rumus Display**: `1/3 × π × r² × t = 1/3 × 3.14 × [value]² × [value]`

### 📐 Bangun Datar (Luas & Keliling)

#### 1. Persegi Panjang
- **Luas**: `p × l`
- **Keliling**: `2 × (p + l)`
- **Input**: Panjang, Lebar

#### 2. Trapesium
- **Luas**: `½ × (a + b) × t`
- **Keliling**: `a + b + c + d` (butuh sisi miring)
- **Input**: Alas Atas, Alas Bawah, Tinggi, Sisi Miring 1, Sisi Miring 2

#### 3. Segitiga
- **Luas**: `½ × a × t`
- **Keliling**: `a + b + c` (butuh ketiga sisi)
- **Input**: Alas, Tinggi, Sisi 1, Sisi 2

#### 4. Lingkaran
- **Luas**: `π × r²`
- **Keliling**: `2 × π × r`
- **Input**: Jari-jari

## 💡 Contoh Penggunaan

### Contoh 1: Menghitung Volume Balok
```
Input:
- Panjang: 5.0
- Lebar: 3.0  
- Tinggi: 2.0

Output:
=== HASIL PERHITUNGAN BANGUN RUANG ===
Bangun Ruang: Balok
Rumus Volume: p × l × t = 5.00 × 3.00 × 2.00
Volume: 30.00
===================================
```

### Contoh 2: Menghitung Luas & Keliling Persegi Panjang
```
Input:
- Panjang: 15.0
- Lebar: 5.0

Output:
=== HASIL PERHITUNGAN BANGUN DATAR ===
Bangun Datar: Persegi Panjang
Rumus Luas: p × l = 15.00 × 5.00
Luas: 75.00
Rumus Keliling: 2 × (p + l) = 2 × (15.00 + 5.00)
Keliling: 40.00
===================================
```

### Contoh 3: Menghitung Volume dan Luas Permukaan Tabung
```
Input:
- Jari-jari: 3.5
- Tinggi: 10.0

Output:
=== HASIL PERHITUNGAN BANGUN RUANG ===
Bangun Ruang: Tabung
Rumus Volume: π × r² × t = 3.14 × 3.50² × 10.00
Volume: 384.65
Rumus Luas Permukaan: 2 × π × r × (r + t) = 2 × 3.14 × 3.50 × (3.50 + 10.00)
Luas Permukaan: 296.88
===================================
```

## ❓ FAQ

### Q: Apakah perlu install database?
**A:** Tidak! Aplikasi menggunakan file text untuk penyimpanan data.

### Q: Bagaimana cara backup history?
**A:** Cukup copy file `history.txt` ke lokasi aman.

### Q: Bisakah menambah bangun ruang sendiri?
**A:** Ya! Lihat section [Pengembangan](#-pengembangan) untuk panduan.

### Q: Apakah support bilangan kompleks?
**A:** Saat ini hanya support bilangan real positif.

### Q: Bagaimana cara reset semua data?
**A:** Hapus file `history.txt` dan restart aplikasi.

### Q: File history disimpan dimana?
**A:** Di file `history.txt` di folder project yang sama.

### Q: Apakah bisa dijalankan di jaringan?
**A:** Ya, aplikasi standalone bisa di-copy ke komputer manapun dengan Java.

---

<div align="center">

## ⭐ Fitur Unggulan ⭐

**"Zero Dependencies, Maximum Functionality!"**

[Kembali ke Atas](#-kalkulator-bangun-ruang--datar)

</div>
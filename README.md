# Schoters Bacarita
Bacarita is a last project for Schoter's virtual intership program which is essentially a news app with data provided from [News API](https://newsapi.org).  Built with MVVM compose repository pattern and clean architecture.

Notice: Untuk pengujian harap menggunakan real device, karena library coil compose tidak dapat melakukan load terhadap beberapa image url saat dicoba menggunakan emulator.

## Tech Stack
- Jetpack Compose for main UI framework
- Coroutines Flow
- Retrofit2 to fetch data from network
- Room Data for data caching
- Dagger-Hilt for dependency injection

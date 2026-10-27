# Actividad 1 — Programación Mobile

Aplicación Android inicial de recordatorios desarrollada con Kotlin, Jetpack Compose y Material 3.

**Estudiante:** Ponce Guillermo
**Repositorio:** https://github.com/guillermoponceguillermo/programacionmobile
**Entrega PDF:** [API 1.pdf](./API%201.pdf)

## Contenido

- `Reminder.kt`: categorías y prioridades enumeradas, estados como `sealed interface` y modelo inmutable con validación de identificador, título y descripción opcional.
- `ReminderSamples.kt`: lista simulada, conjunto de categorías únicas, mapa de colores y filtros por estado y prioridad.
- `MainActivity.kt`: pantalla Compose con título, resumen y tarjetas que muestran título, categoría, prioridad y estado.
- `ReminderTest.kt`: pruebas unitarias para las validaciones y las colecciones simuladas.

## Abrir y ejecutar

1. Instalar Android Studio y, desde SDK Manager, instalar Android SDK Platform 35 y Android SDK Build-Tools.
2. Abrir en Android Studio la carpeta que contiene este archivo.
3. Esperar la sincronización de Gradle. Si Android Studio solicita descargar el Android Gradle Plugin, Kotlin o dependencias, aceptar la descarga.
4. Crear/iniciar un dispositivo en Device Manager o conectar un teléfono con depuración USB.
5. Seleccionar la configuración `app` y pulsar **Run**.
6. Ejecutar las pruebas con **Run tests** o desde la terminal con `.\gradlew.bat testDebugUnitTest`.

El proyecto incluye el wrapper de Gradle 8.9. La primera sincronización requiere conexión para descargar Gradle y las dependencias Android. Android Studio incluye un JDK; si se usa una terminal externa, debe estar disponible Java 17 o posterior.

## Evidencias de entrega

El PDF incluye nombre y apellido, materia, actividad y el enlace a este repositorio. Antes de entregar, hay que reemplazar en el PDF los espacios de captura pendientes con evidencias reales de la pantalla Compose, la aplicación ejecutándose y la estructura en Android Studio. No se incluyen imágenes simuladas.

Al tomar las capturas, identifica cada una con su consigna: pantalla Compose y datos mostrados; ejecución en emulador o dispositivo; estructura del proyecto en Android Studio.

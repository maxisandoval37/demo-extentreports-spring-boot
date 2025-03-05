# 🚀 Configuración de GitHub Pages con Maven, GitHub Actions y Extent Reports (para los tests)

## 📌 1) Crear rama `gh-pages`

Asegúrate de crear una rama llamada `gh-pages` en tu repositorio.


## 🔑 2) Generar Tokens

### 📌 Crear un Token de Acceso Personal (PAT)
1. Ir a **PROFILE -> Settings -> Developer Settings -> Tokens (classic)**
2. Generar un nuevo token con los permisos necesarios (repo, workflow, etc.)
3. Obtendrás un token similar a: `ghp_XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX`

### 📌 Agregar el Token como un Secret en el Repositorio
1. Ir a **REPO -> Settings -> Secrets and variables -> Actions -> New repository secret**
2. Crear un secreto con el nombre `TOKEN_APP` y pegar el token generado


## ⚙️ 3) Configurar GitHub Actions (`.github/workflows/maven.yml`)

```yaml
name: Build and Test

on:
  push:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout Repository
      uses: actions/checkout@v2

    - name: Set up JDK 17
      uses: actions/setup-java@v2
      with:
        distribution: 'adopt'
        java-version: '17'

    - name: Build and Test
      run: mvn clean test

    - name: Move Report to Docs
      run: |
        mkdir -p ./gh-pages
        cp -r target/site/* ./gh-pages/

    - name: Deploy to GitHub Pages
      uses: peaceiris/actions-gh-pages@v3
      with:
        github_token: ${{ secrets.TOKEN_APP }}
        publish_dir: ./gh-pages
```


## 🛠️ 4) Crear y Extender la Clase BaseTest

Es necesario crear y extender de la siguiente clase para los tests con **extentreports**:

🔗 [BaseTest.java](https://github.com/maxisandoval37/demo-extentreports-spring-boot/blob/main/src/test/java/ar/dev/maxisandoval/demoextentreportsspringboot/BaseTest.java)


## 🌍 Acceder a la Página Generada

- [CLICK 👈](https://maxisandoval37.github.io/demo-extentreports-spring-boot/)
- Reemplaza con tu usuario y repositorio: `https://<tu-usuario-github>.github.io/<nombre-repositorio>`

## 📖 Documentación Relacionada

🔗 [Publicar paquetes Java con Maven en GitHub Actions](https://docs.github.com/en/actions/publishing-packages/publishing-java-packages-with-maven)

---

## Información Adicional
Para cualquier información adicional o consultas: <maxisandoval98@gmail.com>

**¡Muchas gracias! 🦔**

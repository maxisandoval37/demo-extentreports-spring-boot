# Configuración de GitHub Pages con Maven, GitHub Actions y Extent Reports (para los tests)

![image](https://github.com/user-attachments/assets/8ef2efb6-d466-48d2-b5b8-6aaca9eab9be)

<p align="center"> 
  <img src="https://github.com/user-attachments/assets/6873e721-f7d9-49ea-8c52-e855aa9ea365"/>
</p>

## 1) Crear rama `gh-pages`

Crear una rama llamada `gh-pages` en el repositorio de Github.

## 2) Generar Tokens

### Crear un Token de Acceso Personal (PAT)
1. Ir a **PROFILE -> Settings -> Developer Settings -> Tokens (classic)**
2. Generar un nuevo token con los permisos necesarios (repo, workflow, etc.)
3. Obtendrás un token similar a: `ghp_XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX`

### Agregar el Token como un Secret en el Repositorio
1. Ir a **REPO -> Settings -> Secrets and variables -> Actions -> New repository secret**
2. Crear un secreto con el nombre `TOKEN_APP` y pegar el token generado

## 3) Configurar GitHub Actions (`.github/workflows/maven.yml`)

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

## 4) Agregar la dependencia de **extentreports** en el pom

```xml

        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.0.9</version>
        </dependency>

```

## 5) Crear y extender la clase BaseTest

Es necesario crear y extender de la siguiente clase para los tests con **extentreports**:

[BaseTest.java](https://github.com/maxisandoval37/demo-extentreports-spring-boot/blob/main/src/test/java/ar/dev/maxisandoval/demoextentreportsspringboot/BaseTest.java)

## Acceder a la Página generada

- [CLICK 👈](https://maxisandoval37.github.io/demo-extentreports-spring-boot/)
- Reemplaza con tu usuario y repositorio: `https://<tu-usuario-github>.github.io/<nombre-repositorio>`

![image](https://github.com/user-attachments/assets/fbe4e23d-c6f7-4a5f-a515-ed4c410bf9d3)

## Documentación Relacionada

🔗 [Publicar paquetes Java con Maven en GitHub Actions](https://docs.github.com/en/actions/publishing-packages/publishing-java-packages-with-maven)

🔗 [Getting Started](https://extentreports.com/docs/versions/5/java/index.html)

---

## Información Adicional
Para cualquier información adicional o consultas: <maxisandoval98@gmail.com>

<p align="center"><b>¡Muchas gracias! 🦔</b></p>

<hr>

![image](https://github.com/user-attachments/assets/61e74945-a287-4266-86c9-faac81d3bfb5)

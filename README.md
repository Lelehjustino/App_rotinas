# 🌱 RotinApp — Rotinas, Metas e Progresso

Aplicativo Android desenvolvido em **Kotlin com Jetpack Compose** — Mínimo Aplicativo Funcional (MAF).

O aplicativo tem como objetivo ajudar o usuário a organizar suas **rotinas, metas e progresso**, permitindo criar, acompanhar e gerenciar suas atividades de forma simples e visual.

---

## 📱 Sobre o projeto

Entre as principais funcionalidades estão:

*  Cadastro e visualização de rotinas
*  Criação e acompanhamento de metas
*  Marcação de metas concluídas
*  Exclusão de metas
*  Visualização do progresso
*  Histórico de atividades
*  Tela de perfil
*  Navegação entre as principais áreas do aplicativo
*  Visualização de detalhes das metas por meio de popup

---

## ✨ Funcionalidades

### 📋 Rotinas

O usuário pode visualizar suas rotinas em uma lista utilizando `LazyColumn`.

Cada rotina apresenta:

* Nome da rotina
* Duração em minutos
* Card individual para organização visual

### 🎯 Metas

A tela de metas permite:

* Criar uma nova meta
* Adicionar nome e descrição
* Marcar uma meta como concluída
* Excluir uma meta
* Visualizar os detalhes da meta

As metas são apresentadas utilizando `LazyColumn` e `Card`.

### 📊 Progresso

A tela de progresso apresenta informações sobre a evolução do usuário, incluindo:

* Nível atual
* Experiência
* Métricas
* Atividade
* Acesso às metas
* Acesso ao histórico

### 📅 Histórico

A tela de histórico permite visualizar atividades realizadas anteriormente, incluindo informações sobre rotinas e metas concluídas.

### 👤 Perfil

A tela de perfil reúne informações relacionadas ao usuário e permite acessar outras áreas complementares do aplicativo.

---

## 🧭 Navegação

O projeto utiliza um **NavHost centralizado** para controlar a navegação entre as telas.

As rotas são organizadas em um objeto específico:

```kotlin
object RotaAbas {
    const val Progresso = "Progresso"
    const val TelaCriacao = "TelaCriacao"
    const val TelaListaRotina = "TelaListaRotina"
    const val TelaRotina = "TelaRotina"
    const val TelaHistorico = "TelaHistorico"
    const val TelaMetas = "TelaMetas"
    const val TelaPerfil = "TelaPerfil"
}
```

A navegação principal também conta com uma **NavigationBar**, permitindo acessar rapidamente as áreas principais do aplicativo.

---

## 🛠️ Tecnologias utilizadas

* **Kotlin**
* **Jetpack Compose**
* **Material 3**
* **Navigation Compose**
* **ViewModel**
* **LazyColumn**
* **mutableStateListOf**
* **Git**
* **GitHub**
* **Android Studio**

---

## 🏗️ Organização do projeto

O projeto está organizado de forma a separar as telas, modelos e componentes utilizados no aplicativo.

Exemplo de organização:

```text
app/
└── src/
    └── main/
        └── java/
            └── com.example.myapplication/
                ├── MainActivity.kt
                ├── AppNavegacao.kt
                ├── RotaAbas.kt
                │
                ├── Telas/
                │   ├── TelaListaRotinas.kt
                │   ├── TelaCriacao.kt
                │   ├── TelaMetas.kt
                │   ├── TelaHistorico.kt
                │   ├── Progresso.kt
                │   └── TelaPerfil.kt
                │
                ├── ViewModel/
                │   ├── MetasViewModel.kt
                │   └── HistoricoViewModel.kt
                │
                └── ui/
                    └── theme/
                        ├── Rotina.kt
                        └── Meta.kt
```

---

## 💾 Gerenciamento dos dados

Os dados utilizados pelo aplicativo são mantidos **em memória** durante a execução.

Para o gerenciamento das listas, são utilizados `ViewModel` e `mutableStateListOf`, permitindo que a interface seja atualizada automaticamente quando os dados são adicionados, alterados ou removidos.

Exemplo:

```kotlin
private val _metas = mutableStateListOf<Meta>()

val metas: List<Meta>
    get() = _metas
```

---

## ▶️ Como executar o projeto

### Pré-requisitos

Para executar o projeto, é necessário ter instalado:

* Android Studio
* JDK compatível com a versão do projeto
* Android SDK
* Um dispositivo Android físico ou emulador

### Passos

1. Clone este repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto no **Android Studio**.

3. Aguarde a sincronização do Gradle.

4. Conecte um dispositivo Android ou inicie um emulador.

5. Execute o projeto pelo botão **Run ▶** do Android Studio.

## 📄 Licença

Projeto desenvolvido para fins acadêmicos.

package screens.black


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import logic_cloaca.StaticVariables

import com.multiplatform.webview.web.WebContent
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.WebViewState
import com.multiplatform.webview.web.rememberWebViewNavigator
import data.repository.StaticDate
import logic_cloaca.Status
import screens.loading.ScreenA
import screens.start.view.ScreenStart

object ScreenBlack: Screen {

    @Composable()
    override fun Content(){
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                        val navigator = rememberWebViewNavigator()
                        WebView(modifier = Modifier.fillMaxSize(),
                            navigator = navigator,
                            state = WebViewState(webContent =  WebContent.Url(StaticVariables.urlFinal)))
                       StaticVariables.goBack = {navigator.navigateBack()}
                    }
                    }



}


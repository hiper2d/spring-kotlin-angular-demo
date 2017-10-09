import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "./app-routing.module";
import {HomeModule} from "./home/home.module";
import {AppComponent} from "./app.component";

@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        BrowserModule,
        HomeModule,
        AppRoutingModule
    ],
    providers: [
    ],
    bootstrap: [
        AppComponent
    ]
})

export class AppModule {

}
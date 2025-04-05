package co.japl.android.torressansebastian.ui.settings

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.japl.android.torressansebastian.ui.view.about.AboutView
import co.japl.android.torressansebastian.ui.view.admin_pay.AdministrationPayView
import co.japl.android.torressansebastian.ui.view.contactus.ContactUs
import co.japl.android.torressansebastian.ui.view.docs.DocumentList
import co.japl.android.torressansebastian.ui.view.garbage.Garbage
import co.japl.android.torressansebastian.ui.view.home.HomeView
import co.japl.android.torressansebastian.ui.view.location.Location
import co.japl.android.torressansebastian.ui.view.messages.Messages
import co.japl.android.torressansebastian.ui.view.noise.Noise
import co.japl.android.torressansebastian.ui.view.parking.Parking
import co.japl.android.torressansebastian.ui.view.pets_ownership.PetsOwnerShip
import co.japl.android.torressansebastian.ui.view.playground.Playground
import co.japl.android.torressansebastian.ui.view.pqr.PQRBilling
import co.japl.android.torressansebastian.ui.view.pqr.PQRGeneral
import co.japl.android.torressansebastian.ui.view.repair.Repair
import co.japl.android.torressansebastian.ui.view.schedule.ScheduleView
import co.japl.android.torressansebastian.ui.view.suggestion_box.SuggestionBox

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Navigator(navController: NavHostController, modifier: Modifier, context: Context){
    NavHost(navController=navController,startDestination= NavigationEnum.Home.getRoute(),modifier=modifier) {
        composable(NavigationEnum.AdministationPayment.getRoute()) {
            AdministrationPayView()
        }
        composable(NavigationEnum.Garbage.getRoute()) {
            Garbage()
        }
        composable(NavigationEnum.Location.getRoute()) {
            Location()
        }
        composable(NavigationEnum.Home.getRoute()) {
            HomeView()
        }
        composable(NavigationEnum.Noise.getRoute()) {
            Noise()
        }
        composable(NavigationEnum.Parking.getRoute()) {
            Parking()
        }
        composable(NavigationEnum.PetsOwnerShip.getRoute()) {
            PetsOwnerShip()
        }
        composable(NavigationEnum.PlayGround.getRoute()) {
            Playground()
        }
        composable(NavigationEnum.Repair.getRoute()) {
            Repair()
        }
        composable(NavigationEnum.ContactUs.getRoute()) {
            ContactUs()
        }

        composable(NavigationEnum.Schedule.getRoute()) {
            ScheduleView()
        }

        composable(NavigationEnum.AboutBy.getRoute()) {
            AboutView()
        }

        composable(NavigationEnum.PRQGeneral.getRoute()) {
            PQRGeneral()
        }

        composable(NavigationEnum.PRQBilling.getRoute()) {
            PQRBilling()
        }
        composable(NavigationEnum.SuggestionBox.getRoute()) {
            SuggestionBox()
        }
        composable(NavigationEnum.DocFiles.getRoute()) {
            DocumentList()
        }
        composable(NavigationEnum.Messages.getRoute()) {
            Messages()
        }
    }
}
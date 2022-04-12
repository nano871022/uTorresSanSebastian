package co.japl.android.torressansebastian

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.support.design.widget.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import co.japl.android.torressansebastian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            val email = getString(R.string.administration_email)
            val sent: Intent = Intent(Intent.ACTION_SEND)
            sent.type ="text/plain"
            sent.putExtra(Intent.EXTRA_EMAIL,arrayOf(email))
            sent.data = Uri.parse("mailto:")
            sent.putExtra(Intent.EXTRA_SUBJECT,"Administracion")

            startActivity(Intent.createChooser(sent,"Send email"))
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_information, R.id.nav_location, R.id.nav_contact_us, R.id.nav_suggestion,R.id.nav_complaints, R.id.nav_parking, R.id.nav_admin_pay,R.id.nav_pet_ownership
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
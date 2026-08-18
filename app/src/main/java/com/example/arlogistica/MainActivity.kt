package com.example.arlogistica

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {


    // ==========================
    // MODELOS
    // ==========================


    data class Solicitud(
        val origen: String,
        val destino: String,
        val tipoCarga: String,
        val descripcion: String,
        val fecha: String,
        var estado: String = "Pendiente"
    )


    data class Vehiculo(
        val placa: String,
        val tipo: String,
        val capacidad: String,
        var estado: String = "Disponible"
    )


    data class Conductor(
        val nombre: String,
        val cedula: String,
        val telefono: String,
        val licencia: String,
        var estado: String = "Disponible"
    )


    data class Asignacion(
        val solicitud: Solicitud,
        val vehiculo: Vehiculo,
        val conductor: Conductor,
        var estado: String = "Asignado"
    )



    // ==========================
    // LISTAS
    // ==========================


    private val listaSolicitudes =
        mutableListOf<Solicitud>()


    private val listaAsignaciones =
        mutableListOf<Asignacion>()



    private val listaVehiculos =
        mutableListOf(

            Vehiculo(
                "ABC123",
                "Camión",
                "10 toneladas"
            ),

            Vehiculo(
                "XYZ789",
                "Camioneta",
                "5 toneladas"
            ),

            Vehiculo(
                "LMN456",
                "Furgón",
                "8 toneladas"
            )

        )



    private val listaConductores =
        mutableListOf(

            Conductor(
                "Carlos Pérez",
                "1020304050",
                "3000000000",
                "C2"
            ),

            Conductor(
                "Andrés Gómez",
                "1010101010",
                "3100000000",
                "C3"
            )

        )



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        mostrarInicio()

    }



    // ==========================
    // INICIO
    // ==========================


    private fun mostrarInicio() {


        setContentView(
            R.layout.activity_main
        )


        val btn =
            findViewById<MaterialButton>(
                R.id.btnIniciarSesion
            )


        btn.setOnClickListener {

            mostrarLogin()

        }

    }



    // ==========================
    // LOGIN
    // ==========================


    private fun mostrarLogin() {


        setContentView(
            R.layout.activity_login
        )


        val spinner =
            findViewById<Spinner>(
                R.id.spinnerRol
            )


        val btn =
            findViewById<Button>(
                R.id.btnIngresar
            )



        val roles = arrayOf(

            "Administrador",
            "Conductor",
            "Cliente"

        )



        spinner.adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                roles
            )



        btn.setOnClickListener {


            when(
                spinner.selectedItemPosition
            ){

                0 -> mostrarAdministrador()

                1 -> mostrarConductores()

                2 -> mostrarCliente()

            }

        }

    }



    // ==========================
    // ADMINISTRADOR
    // ==========================


    private fun mostrarAdministrador() {


        setContentView(
            R.layout.activity_admin
        )


        val btnSolicitudes =
            findViewById<Button>(
                R.id.btnSolicitudes
            )


        val btnVehiculos =
            findViewById<Button>(
                R.id.btnVehiculos
            )


        val btnConductores =
            findViewById<Button>(
                R.id.btnConductores
            )


        val btnAsignaciones =
            findViewById<Button>(
                R.id.btnAsignaciones
            )


        val btnCerrar =
            findViewById<Button>(
                R.id.btnCerrarSesionAdmin
            )



        btnSolicitudes.setOnClickListener {

            mostrarListaSolicitudes()

        }



        btnVehiculos.setOnClickListener {

            mostrarVehiculos()

        }



        btnConductores.setOnClickListener {

            mostrarConductores()

        }



        btnAsignaciones.setOnClickListener {

            mostrarAsignaciones()

        }



        btnCerrar.setOnClickListener {

            mostrarInicio()

        }


    }
    // ==========================
// PANEL CONDUCTOR
// ==========================

    private fun mostrarConductor() {


        setContentView(
            R.layout.activity_driver
        )


        val btnServicios =
            findViewById<Button>(
                R.id.btnServiciosAsignados
            )


        val btnRuta =
            findViewById<Button>(
                R.id.btnVerRuta
            )


        val btnEstado =
            findViewById<Button>(
                R.id.btnActualizarEstado
            )


        val btnNovedad =
            findViewById<Button>(
                R.id.btnReportarNovedad
            )


        val btnCerrar =
            findViewById<Button>(
                R.id.btnCerrarSesionConductor
            )



        btnServicios.setOnClickListener {

            mostrarServiciosConductor()


        }



        btnRuta.setOnClickListener {

            Toast.makeText(
                this,
                "Consulta de ruta",
                Toast.LENGTH_SHORT
            ).show()

        }



        btnEstado.setOnClickListener {

            Toast.makeText(
                this,
                "Actualizar estado del viaje",
                Toast.LENGTH_SHORT
            ).show()

        }



        btnNovedad.setOnClickListener {

            Toast.makeText(
                this,
                "Reportar novedad",
                Toast.LENGTH_SHORT
            ).show()

        }



        btnCerrar.setOnClickListener {

            mostrarInicio()

        }

    }
    // ==========================
    // CLIENTE
    // ==========================


    private fun mostrarCliente() {


        setContentView(
            R.layout.activity_client
        )


        val btnSolicitar =
            findViewById<Button>(
                R.id.btnSolicitarTransporteCliente
            )


        val btnCerrar =
            findViewById<Button>(
                R.id.btnCerrarSesionCliente
            )


        btnSolicitar.setOnClickListener {

            mostrarSolicitudCliente()

        }


        btnCerrar.setOnClickListener {

            mostrarInicio()

        }


    }



    // ==========================
    // CREAR SOLICITUD
    // ==========================


    private fun mostrarSolicitudCliente() {


        setContentView(
            R.layout.activity_request
        )


        val origen =
            findViewById<EditText>(
                R.id.edtOrigen
            )


        val destino =
            findViewById<EditText>(
                R.id.edtDestino
            )


        val carga =
            findViewById<EditText>(
                R.id.edtTipoCarga
            )


        val descripcion =
            findViewById<EditText>(
                R.id.edtDescripcionCarga
            )


        val fecha =
            findViewById<EditText>(
                R.id.edtFechaServicio
            )


        val enviar =
            findViewById<Button>(
                R.id.btnEnviarSolicitud
            )


        val cancelar =
            findViewById<Button>(
                R.id.btnCancelarSolicitud
            )



        enviar.setOnClickListener {


            if(
                origen.text.isEmpty() ||
                destino.text.isEmpty() ||
                carga.text.isEmpty() ||
                descripcion.text.isEmpty() ||
                fecha.text.isEmpty()

            ){

                Toast.makeText(
                    this,
                    "Complete todos los campos",
                    Toast.LENGTH_SHORT
                ).show()


            }else{


                val solicitud =
                    Solicitud(

                        origen.text.toString(),

                        destino.text.toString(),

                        carga.text.toString(),

                        descripcion.text.toString(),

                        fecha.text.toString()

                    )



                listaSolicitudes.add(
                    solicitud
                )



                Toast.makeText(
                    this,
                    "Solicitud enviada correctamente",
                    Toast.LENGTH_LONG
                ).show()



                mostrarCliente()

            }

        }



        cancelar.setOnClickListener {

            mostrarCliente()

        }


    }





    // ==========================
    // SOLICITUDES ADMIN
    // ==========================


    private fun mostrarListaSolicitudes() {


        setContentView(
            R.layout.activity_admin_solicitudes
        )


        val contenedor =
            findViewById<LinearLayout>(
                R.id.contenedorSolicitudes
            )


        val volver =
            findViewById<Button>(
                R.id.btnVolverAdmin
            )



        contenedor.removeAllViews()



        listaSolicitudes.forEachIndexed {

                index,
                solicitud ->



            val vista =
                layoutInflater.inflate(

                    R.layout.item_solicitud,

                    contenedor,

                    false

                )



            val titulo =
                vista.findViewById<TextView>(
                    R.id.txtTituloSolicitud
                )


            val origen =
                vista.findViewById<TextView>(
                    R.id.txtOrigen
                )


            val destino =
                vista.findViewById<TextView>(
                    R.id.txtDestino
                )


            val carga =
                vista.findViewById<TextView>(
                    R.id.txtCarga
                )


            val fecha =
                vista.findViewById<TextView>(
                    R.id.txtFecha
                )


            val estado =
                vista.findViewById<TextView>(
                    R.id.txtEstado
                )


            val asignar =
                vista.findViewById<Button>(
                    R.id.btnAsignar
                )


            val detalle =
                vista.findViewById<Button>(
                    R.id.btnDetalle
                )



            titulo.text =
                "Solicitud #${index+1}"


            origen.text =
                "Origen: ${solicitud.origen}"


            destino.text =
                "Destino: ${solicitud.destino}"


            carga.text =
                "Carga: ${solicitud.tipoCarga}"


            fecha.text =
                "Fecha: ${solicitud.fecha}"


            estado.text =
                "Estado: ${solicitud.estado}"



            asignar.setOnClickListener {

                mostrarAsignar(
                    solicitud
                )

            }



            detalle.setOnClickListener {


                Toast.makeText(

                    this,

                    "Solicitud de ${solicitud.origen} a ${solicitud.destino}",

                    Toast.LENGTH_LONG

                ).show()


            }



            contenedor.addView(
                vista
            )


        }



        volver.setOnClickListener {

            mostrarAdministrador()

        }


    }
    // ==========================
    // ASIGNAR SERVICIO
    // ==========================


    private fun mostrarAsignar(
        solicitud: Solicitud
    ) {


        setContentView(
            R.layout.activity_asignar
        )


        val txtSolicitud =
            findViewById<TextView>(
                R.id.txtSolicitudAsignar
            )


        val spinnerVehiculo =
            findViewById<Spinner>(
                R.id.spinnerVehiculo
            )


        val spinnerConductor =
            findViewById<Spinner>(
                R.id.spinnerConductor
            )


        val confirmar =
            findViewById<Button>(
                R.id.btnConfirmarAsignacion
            )


        val cancelar =
            findViewById<Button>(
                R.id.btnCancelarAsignacion
            )



        txtSolicitud.text =
            """
            Solicitud:

            ${solicitud.origen}
            →
            ${solicitud.destino}

            Carga:
            ${solicitud.tipoCarga}
            """.trimIndent()



        spinnerVehiculo.adapter =
            ArrayAdapter(

                this,

                android.R.layout.simple_spinner_dropdown_item,

                listaVehiculos.map {

                    "${it.placa} - ${it.tipo}"

                }

            )



        spinnerConductor.adapter =
            ArrayAdapter(

                this,

                android.R.layout.simple_spinner_dropdown_item,

                listaConductores.map {

                    "${it.nombre} - ${it.licencia}"

                }

            )



        confirmar.setOnClickListener {


            val vehiculo =

                listaVehiculos[
                    spinnerVehiculo.selectedItemPosition
                ]



            val conductor =

                listaConductores[
                    spinnerConductor.selectedItemPosition
                ]



            listaAsignaciones.add(

                Asignacion(

                    solicitud,

                    vehiculo,

                    conductor

                )

            )



            solicitud.estado =
                "Asignada"



            Toast.makeText(

                this,

                "Asignación creada correctamente",

                Toast.LENGTH_LONG

            ).show()



            mostrarAdministrador()


        }



        cancelar.setOnClickListener {

            mostrarListaSolicitudes()

        }


    }





    // ==========================
    // VEHICULOS
    // ==========================


    private fun mostrarVehiculos() {


        setContentView(
            R.layout.activity_vehiculos
        )


        val contenedor =
            findViewById<LinearLayout>(
                R.id.contenedorVehiculos
            )


        val volver =
            findViewById<Button>(
                R.id.btnVolverVehiculos
            )


        contenedor.removeAllViews()



        listaVehiculos.forEach {


            val texto =
                TextView(this)



            texto.text =
                """

                Placa:
                ${it.placa}

                Tipo:
                ${it.tipo}

                Capacidad:
                ${it.capacidad}

                Estado:
                ${it.estado}

                -----------------

                """.trimIndent()



            texto.textSize = 16f



            contenedor.addView(
                texto
            )


        }



        volver.setOnClickListener {

            mostrarAdministrador()

        }


    }





    // ==========================
    // CONDUCTORES
    // ==========================


    private fun mostrarConductores() {


        setContentView(
            R.layout.activity_conductores
        )


        val contenedor =
            findViewById<LinearLayout>(
                R.id.contenedorConductores
            )

        val volver =
            findViewById<Button>(
                R.id.btnVolverConductores
            )



        contenedor.removeAllViews()



        listaConductores.forEach {


            val texto =
                TextView(this)



            texto.text =
                """

                Nombre:
                ${it.nombre}

                Cédula:
                ${it.cedula}

                Teléfono:
                ${it.telefono}

                Licencia:
                ${it.licencia}

                Estado:
                ${it.estado}

                -----------------

                """.trimIndent()



            texto.textSize = 16f



            contenedor.addView(
                texto
            )


        }



        volver.setOnClickListener {

            mostrarAdministrador()

        }


    }





    // ==========================
    // ASIGNACIONES
    // ==========================


    private fun mostrarAsignaciones() {


        setContentView(
            R.layout.activity_asignaciones
        )


        val contenedor =
            findViewById<LinearLayout>(
                R.id.contenedorAsignaciones
            )


        val volver =
            findViewById<Button>(
                R.id.btnVolverAsignaciones
            )



        contenedor.removeAllViews()



        if(listaAsignaciones.isEmpty()) {


            val texto =
                TextView(this)


            texto.text =
                "No hay asignaciones registradas"


            texto.textSize = 18f


            contenedor.addView(
                texto
            )


        }else{


            listaAsignaciones.forEachIndexed{

                    index,
                    asignacion ->



                val texto =
                    TextView(this)



                texto.text =
                    """

                    ASIGNACIÓN #${index+1}


                    Ruta:

                    ${asignacion.solicitud.origen}

                    →

                    ${asignacion.solicitud.destino}


                    Vehículo:

                    ${asignacion.vehiculo.placa}


                    Conductor:

                    ${asignacion.conductor.nombre}


                    Estado:

                    ${asignacion.estado}


                    -------------------

                    """.trimIndent()



                texto.textSize = 16f



                contenedor.addView(
                    texto
                )


            }


        }



        volver.setOnClickListener {

            mostrarAdministrador()

        }


    }

    private fun mostrarServiciosConductor() {


        setContentView(
            R.layout.activity_servicios_conductor
        )


        val contenedor =
            findViewById<LinearLayout>(
                R.id.contenedorServiciosConductor
            )
        val btnActualizar =
            findViewById<Button>(
                R.id.btnActualizarEstadoViaje
            )



        contenedor.removeAllViews()



        if(listaAsignaciones.isEmpty()) {


            val mensaje =
                TextView(this)


            mensaje.text =
                "No tienes servicios asignados"


            mensaje.textSize = 18f


            contenedor.addView(
                mensaje
            )



        } else {


            listaAsignaciones.forEachIndexed { index, asignacion ->


                val servicio =
                    TextView(this)


                servicio.text =
                    """
                
                SERVICIO #${index + 1}

                ORIGEN:
                ${asignacion.solicitud.origen}

                DESTINO:
                ${asignacion.solicitud.destino}

                VEHÍCULO:
                ${asignacion.vehiculo.placa}

                CONDUCTOR:
                ${asignacion.conductor.nombre}

                CARGA:
                ${asignacion.solicitud.tipoCarga}

                ESTADO:
                ${asignacion.estado}

                ----------------------------

                """.trimIndent()



                servicio.textSize = 16f


                servicio.setPadding(
                    20,
                    20,
                    20,
                    20
                )
                val btnEstado =
                    Button(this)


                btnEstado.text =
                    "Actualizar estado"


                btnEstado.setOnClickListener {


                    asignacion.estado =
                        when(asignacion.estado){

                            "Asignado" ->
                                "Aceptado"


                            "Aceptado" ->
                                "En ruta"


                            "En ruta" ->
                                "Entregado"


                            else ->
                                "Entregado"

                        }


                    Toast.makeText(
                        this,
                        "Estado: ${asignacion.estado}",
                        Toast.LENGTH_SHORT
                    ).show()


                    mostrarServiciosConductor()

                }


                contenedor.addView(servicio)

                contenedor.addView(btnEstado)


            }

        }



            if(listaAsignaciones.isNotEmpty()) {


                val servicio =
                    listaAsignaciones[0]


                servicio.estado =
                    when(servicio.estado){

                        "Asignado" ->
                            "Aceptado"


                        "Aceptado" ->
                            "En ruta"


                        "En ruta" ->
                            "Entregado"


                        else ->
                            "Entregado"

                    }


                Toast.makeText(

                    this,

                    "Estado actualizado: ${servicio.estado}",

                    Toast.LENGTH_LONG

                ).show()


                mostrarServiciosConductor()


            } else {


                Toast.makeText(

                    this,

                    "No hay servicios asignados",

                    Toast.LENGTH_SHORT

                ).show()

            }

        }
    }






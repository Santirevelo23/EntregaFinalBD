package com.basesdedatos.view;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.basesdedatos.model.Medico;
import com.basesdedatos.model.Paciente;
import com.basesdedatos.model.Tratamiento;
import com.basesdedatos.repository.MedicosRepository;
import com.basesdedatos.repository.PacientesRepository;
import com.basesdedatos.repository.TratamientosRepository;

public class SwingApp extends JFrame {

    private final MedicosRepository medicosRepository;
    private final PacientesRepository pacientesRepository;
    private final TratamientosRepository tratamientosRepository;
    private String apellidoIngresado;
    private String tratamientoIngresado;


    public SwingApp() {
        setTitle("Gestión de Clínica Médica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        add(mainPanel);

        medicosRepository = new MedicosRepository();
        pacientesRepository = new PacientesRepository();
        tratamientosRepository = new TratamientosRepository();

        getButtonMedicosEspecialistas(mainPanel);
        geButtonPacientesPorApellidoIngresado(mainPanel);
        getButtonTipoTratamiento(mainPanel);
        getButtonInformcacionDeContacto(mainPanel);
        getButtonMedicosNoEspecialistas(mainPanel);
        getButtonCantiadadTipoTratamiento(mainPanel);
        getButtonTratamientosLargoPlazo(mainPanel);
        getButtonPacientesEnMasDeUnTratamiento(mainPanel);
        
    }


    private void getButtonMedicosEspecialistas(JPanel mainPanel ){
        JButton consultaMedicosButton = new JButton("Consultar Médicos Especialistas");
        consultaMedicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Medico> especialistas = medicosRepository.findAllByEspecialist();
                    StringBuilder result = new StringBuilder();
                    result.append("Médicos Especialistas:\n");
                    for (Medico medico : especialistas) {
                        result.append(medico.getNombre()).append(" ").append(medico.getApellido()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Médicos Especialistas", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar médicos especialistas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaMedicosButton);
    }

    private void geButtonPacientesPorApellidoIngresado(JPanel mainPanel){
        JButton consultaPacientesPorApellidoButton = new JButton("Consultar Pacientes por Apellido");
        consultaPacientesPorApellidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (apellidoIngresado == null) {
                    apellidoIngresado = JOptionPane.showInputDialog(SwingApp.this, "Ingrese el apellido del paciente:");
                }
                try {
                    List<Paciente> pacientes = pacientesRepository.findAllByLastName(apellidoIngresado);
                    StringBuilder result = new StringBuilder();
                    result.append("Pacientes:\n");
                    for (Paciente paciente : pacientes) {
                        result.append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Pacientes", JOptionPane.INFORMATION_MESSAGE);
                    apellidoIngresado = null;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar Pacientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaPacientesPorApellidoButton);
    }

    private void getButtonTipoTratamiento(JPanel mainPanel) {
        JButton consultaTipoTratamientoButton = new JButton("Consultar Tipo de tratamientos");
        consultaTipoTratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tratamientoIngresado == null) {
                    tratamientoIngresado = JOptionPane.showInputDialog(SwingApp.this, "Ingrese el tipo de tratamiento:");
                }
                try {
                    TratamientosRepository tratamientosRepository = new TratamientosRepository();
                    List<Tratamiento> tratamientos = tratamientosRepository.findAllSegunElTipoTratamiento(tratamientoIngresado);
                    StringBuilder result = new StringBuilder();
                    result.append("Tratamientos:\n");
                    for (Tratamiento tratamiento : tratamientos) {
                        result.append(tratamiento.getIdTratamientos()).append(" ").append(tratamiento.getTipo_tratamiento()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Tratamientos", JOptionPane.INFORMATION_MESSAGE);
                    tratamientoIngresado = null;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar Tratamientos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaTipoTratamientoButton);
    }
    

    private void getButtonInformcacionDeContacto(JPanel mainPanel ){
        JButton consultaInformcacionDeContactoButton = new JButton("Consultar Informacion de Contacto");
        consultaInformcacionDeContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Paciente> pacientes = pacientesRepository.findAllInformcacionDeContacto();
                    StringBuilder result = new StringBuilder();
                    result.append("Informacion de Contacto:\n");
                    for (Paciente paciente : pacientes) {
                        result.append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n").append(paciente.getNoTelefono()).append(" ");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Informacion de Contacto", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar Informacion de Contacto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaInformcacionDeContactoButton);
    }

    private void getButtonMedicosNoEspecialistas(JPanel mainPanel ){
        JButton consultaMedicosNoEspecialistasButton = new JButton("Consultar Médicos No Especialistas");
        consultaMedicosNoEspecialistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Medico> especialistas = medicosRepository.findAllByNoEspecialist();
                    StringBuilder result = new StringBuilder();
                    result.append("Médicos No Especialistas:\n");
                    for (Medico medico : especialistas) {
                        result.append(medico.getNombre()).append(" ").append(medico.getApellido()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Médicos No Especialistas", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar médicos no especialistas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaMedicosNoEspecialistasButton);
    }


    private void getButtonCantiadadTipoTratamiento(JPanel mainPanel ){
        JButton consultaCantiadadTipoTratamientoButton = new JButton("Cantidad Tratamientos de cada Tipo");
        consultaCantiadadTipoTratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Tratamiento> tratamientos = tratamientosRepository.findAllCantiadadTipoTratamiento();
                    StringBuilder result = new StringBuilder();
                    result.append("\n");
                    for (Tratamiento tratamiento : tratamientos) {
                        result.append(tratamiento.getTipo_tratamiento()).append(" ").append(tratamiento.getCantidad()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Cantidad Tratamientos de cada Tipo", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar Cantidad Tratamientos de cada Tipo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaCantiadadTipoTratamientoButton);
    }

    private void getButtonTratamientosLargoPlazo(JPanel mainPanel) {
        JButton consultaTratamientosLargoPlazoButton = new JButton("Tratamientos a largo Plazo");
        consultaTratamientosLargoPlazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Tratamiento> tratamientos = tratamientosRepository.findAllTratamientosLargoPlazo();
                    StringBuilder result = new StringBuilder();
                    result.append("Tratamientos a largo Plazo:\n");
                    for (Tratamiento tratamiento : tratamientos) {
                        result.append("ID: ").append(tratamiento.getIdTratamientos())
                              .append(", Tipo: ").append(tratamiento.getTipo_tratamiento())
                              .append(", Tiempo de consumo: ").append(tratamiento.getTiempo_consumo())
                              .append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Tratamientos a largo Plazo", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar Tratamientos a largo Plazo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaTratamientosLargoPlazoButton);
    }
    


    private void getButtonPacientesEnMasDeUnTratamiento(JPanel mainPanel) {
        JButton consultaPacientesButton = new JButton("Pacientes en más de un tratamiento");
        consultaPacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Tratamiento> tratamientos = tratamientosRepository.findAllPacientasConMasDeUnTratamiento();
                    StringBuilder result = new StringBuilder();
                    result.append("\n");
                    for (Tratamiento tratamiento : tratamientos) {
                        result.append(tratamiento.getPaciente().getNombre()).append(" ").append(tratamiento.getPaciente().getApellido()).append(" ").append(tratamiento.getCantidad()).append("\n");
                    }
                    JOptionPane.showMessageDialog(SwingApp.this, result.toString(), "Pacientes en más de un tratamiento", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SwingApp.this, "Error al consultar Pacientes en más de un tratamiento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(consultaPacientesButton);
    }
    
}

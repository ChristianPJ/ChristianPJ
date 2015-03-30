package com.inftel.museoinftel.utility;


import com.inftel.museoinftel.entity.Minijuego;
import com.inftel.museoinftel.entity.Pregunta;
import com.inftel.museoinftel.service.RequestQuizTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DbQuiz {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "triviaQuiz";

    private List <Minijuego> listaPreguntas;
    private List<Pregunta> listQuestions;


    public List<Pregunta> getAllQuestions() {
        getQuestions();
        addQuestions();
        return listQuestions;
    }

	private void addQuestions()
	{
        listQuestions = new ArrayList<>();

        Collections.shuffle(listaPreguntas);

        Pregunta question;

        for(int i=0;i<5;i++){
            List<String> respuestas = new ArrayList<>();
            respuestas.add(listaPreguntas.get(i).getRespuesta1());
            respuestas.add(listaPreguntas.get(i).getRespuesta2());
            respuestas.add(listaPreguntas.get(i).getRepuesta3());
            Collections.shuffle(respuestas);
            question=new Pregunta(listaPreguntas.get(i).getPregunta(),
                    respuestas.get(0), respuestas.get(1), respuestas.get(2), listaPreguntas.get(i).getRespuesta1());
            listQuestions.add(question);
        }
	}

    public void getQuestions(){
        try{
            listaPreguntas=new RequestQuizTask().execute(Conexion.MUSEO_SERVER+Conexion.QUESTION_RESOURCE).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

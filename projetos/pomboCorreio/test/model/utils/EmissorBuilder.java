package model.utils;

import model.entities.Emissor;
import model.entities.Pombo;
import model.entities.Receptor;

public class EmissorBuilder {

	private Emissor emissor;

	// -------------------------------------

	public EmissorBuilder() {
		emissor = new Emissor(1, "Eren", 20, new Pombo(1, "Pombonaldo", new Receptor(1, "Floch", 20)));
	}

	// -------------------------------------

	public Emissor getEmissor() {
		return emissor;
	}

}

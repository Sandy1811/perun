package cz.metacentrum.perun.audit.events.RegistrarManagerEvents;

import cz.metacentrum.perun.audit.events.AuditEvent;
import cz.metacentrum.perun.audit.events.EngineIgnoreEvent;
import cz.metacentrum.perun.registrar.model.ApplicationForm;

public class FormItemAdded extends AuditEvent implements EngineIgnoreEvent {

	private ApplicationForm form;
	private String message;

	@SuppressWarnings("unused") // used by jackson mapper
	public FormItemAdded() {
	}

	public FormItemAdded(ApplicationForm form) {
		this.form = form;
		this.message = formatMessage("Application form item ID=%d voID=%d %s has been added", form.getId(),
				form.getVo().getId(), ((form.getGroup() != null) ? " groupID=" + form.getGroup().getId() : ""));
	}

	@Override
	public String getMessage() {
		return message;
	}

	public ApplicationForm getForm() {
		return form;
	}

	@Override
	public String toString() {
		return message;
	}
}

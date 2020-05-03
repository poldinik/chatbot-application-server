package it.unifi.ing.swam.dao;

import it.unifi.ing.swam.model.Agent;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AgentDao extends Crud<Agent> {

    public Agent getAgentById(Integer id){
        return entityManager.createQuery("SELECT A FROM Agent A JOIN FETCH A.intents I JOIN FETCH I.contextRelList CR JOIN FETCH CR.context JOIN FETCH CR.contextRelType JOIN FETCH I.parameters P JOIN FETCH I.requiredParameters RP JOIN FETCH I.phrases JOIN FETCH I.textResponses JOIN FETCH A.types WHERE A.id = :id", Agent.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList()
                .get(0);
    }
}

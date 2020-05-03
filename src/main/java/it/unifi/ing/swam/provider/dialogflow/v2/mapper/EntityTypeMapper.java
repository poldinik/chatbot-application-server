package it.unifi.ing.swam.provider.dialogflow.v2.mapper;

import it.unifi.ing.swam.dto.TypeDto;
import it.unifi.ing.swam.dto.TypeEntry;
import it.unifi.ing.swam.provider.dialogflow.v2.schema.Entity;
import it.unifi.ing.swam.provider.dialogflow.v2.schema.EntityType;
import it.unifi.ing.swam.provider.dialogflow.v2.schema.Kind;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class EntityTypeMapper {

    public static EntityType create(TypeDto type, String projectId){
        log.info("Inizio mapping entity type dialogflow....");

        List<TypeEntry> typeEntries = type.getPossibleEntries();
        EntityType entityType = new EntityType();
        entityType.setDisplayName(type.getName());
        entityType.setKind(Kind.KIND_MAP);
        List<Entity> entities = new ArrayList<>();

        for (TypeEntry typeEntry : typeEntries) {
            Entity entity = new Entity();
            List<String> values = typeEntry.getValues();
            entity.setValue(values.get(0));
            log.info("Creazione Entity Dialogflow: " + entity.getValue());

            List<String> synonyms = new ArrayList<>();

            for(int i = 1; i < values.size(); i++){
                synonyms.add(values.get(i));
            }

            entity.setSynonyms(synonyms);
            entities.add(entity);
        }

        entityType.setEntities(entities);
        log.info("Mapping entity completato");

        return entityType;
    }
}




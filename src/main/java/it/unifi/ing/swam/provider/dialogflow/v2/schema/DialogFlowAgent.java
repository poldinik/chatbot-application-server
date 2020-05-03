package it.unifi.ing.swam.provider.dialogflow.v2.schema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DialogFlowAgent {
    private String parent;
    private String displayName;
    private String defaultLanguageCode;
    private String[] supportedLanguageCodes;
    private String timeZone;
    private String description;
    private String avatarUri;
    private boolean enableLogging;
    private MatchMode matchMode;
    private Double classificationThreshold;
    private ApiVersion apiVersion;
    private Tier tier;

}

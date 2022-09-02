package maksym.kruhovykh.moneyk.shared;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {
    public static final class ExceptionMessages {
        private ExceptionMessages() {
        }
       public static final String ENTITY_NOT_FOUND_WITH_ID = "Entity with id [%s] not found.";
        public static final String COULD_NOT_UPDATE_ENTITY_WITH_ID = "Could not UPDATE Entity with id [%s]";

    }

}

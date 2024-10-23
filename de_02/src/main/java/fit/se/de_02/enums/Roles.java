package fit.se.de_02.enums;

public enum Roles {
   ADMINISTRATOR,
   STAFF,
   MANAGER,
   EXECUTIVE;

   public Roles getRole(String role) {
      for (Roles r : Roles.values()) {
         if (r.toString().equalsIgnoreCase(role)) {
            return r;
         }
      }
      return null;
   }
}

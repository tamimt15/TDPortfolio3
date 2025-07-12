import java.util.List;
import java.util.Random;

public class M3Portafolio {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();

        usuarioService.addUsuario(new Usuario(1, "Pedro Perez", "pperez@email.com"));
        usuarioService.addUsuario(new Usuario(2, "Ana Acevedo", "aacevedo@email.com"));
        usuarioService.addUsuario(new Usuario(3, "Luis Lizana", "llizana@email.com"));
        usuarioService.addUsuario(new Usuario(4, "Diego Diaz", "ddiaz@email.com"));
        usuarioService.addUsuario(new Usuario(5, "Daniela Puente", "dpuente@email.com"));
        usuarioService.addUsuario(new Usuario(6, "Lulu", "lulu@email.com"));
        usuarioService.addUsuario(new Usuario(7, "Matias Li", "mli@email.com"));
        usuarioService.addUsuario(new Usuario(8, "Beatriz Solano", "bsolano@email.com"));

        System.out.println(" ***** 8 usuarios creados.");

        System.out.println(" ***** Lista de usuarios:");
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }

        if (!usuarios.isEmpty()) {
            Random random = new Random();
            Usuario randomUsuario = usuarios.get(random.nextInt(usuarios.size()));
            System.out.println(" ***** Usuario aleatorio:");
            System.out.println(randomUsuario);
        }

        if (!usuarios.isEmpty()) {
            Random random = new Random();
            Usuario randomUsuario = usuarios.get(random.nextInt(usuarios.size()));
            boolean updated = usuarioService.updateUsuario(
                randomUsuario.getId(),
                randomUsuario.getName(),
                "Nuevo@email.Com"
            );
            if (updated) {
                System.out.println(" ***** Usuario actualizado: " + usuarioService.getUsuarioById(randomUsuario.getId()));
            } else {
                System.out.println("No se pudo actualizar el usuario.");
            }
        }

        usuarios = usuarioService.getAllUsuarios(); 
        if (!usuarios.isEmpty()) {
            Random random = new Random();
            Usuario randomUsuario = usuarios.get(random.nextInt(usuarios.size()));
            boolean deleted = usuarioService.deleteUsuario(randomUsuario.getId());
            if (deleted) {
                System.out.println(" ***** Usuario eliminado: " + randomUsuario);
            } else {
                System.out.println("No se pudo eliminar el usuario.");
            }
        }

        System.out.println(" ***** Lista de usuarios posteliminación:");
        usuarios = usuarioService.getAllUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
package Model;


public class Login {
	
	private static Login instance;
	
	private int id;
    private String nome;
    private String datadenascimento;
    private String sexo;
    private String email;
    private String telefoneresidencial;
    private String telefonecelular;
    private String universidade;
    private String curso;
    
    private String usuario;
    private String senha;
    private String confirmarsenha;
    
    private String perguntasecreta;
    
    private String cargo;
    private String categoria;
    
    
    public static Login getInstance() {
        if (instance == null)
            instance = new Login();
        return instance;
    }    

    public String getNomeCompleto() {
        return nome;
    }

    public void setNomeCompleto(String Nome_Completo) {
        this.nome = Nome_Completo;
    }

    public String getDataDeNascimento() {
        return datadenascimento;
    }

    public void setDataDeNascimento(String Data_de_Nascimento) {
        this.datadenascimento = Data_de_Nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String Sexo) {
        this.sexo = Sexo;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getTelefoneResidencial() {
        return telefoneresidencial;
    }

    public void setTelefoneResidencial(String Telefone_Residencial) {
        this.telefoneresidencial = Telefone_Residencial;
    }

    public String getTelefoneCelular() {
        return telefonecelular;
    }

    public void setTelefoneCelular(String Telefone_Celular) {
        this.telefonecelular = Telefone_Celular;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String Universidade) {
        this.universidade = Universidade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String Curso) {
        this.curso = Curso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }

    public String getConfirmarSenha() {
        return confirmarsenha;
    }

    public void setConfirmarSenha(String ConfirmarSenha) {
        this.confirmarsenha = ConfirmarSenha;
    }

    public String getPerguntaSecreta() {
        return perguntasecreta;
    }

    public void setPerguntaSecreta(String PerguntaSecreta) {
        this.perguntasecreta = PerguntaSecreta;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String Cargo) {
        this.cargo = Cargo;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
            
}
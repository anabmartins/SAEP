import { useState } from 'react';
import axios from 'axios';

const logar = async (email: any, senha: any) => {
  try {
    const response = await axios.post('http://localhost:8090/api/login', {
      email: email,
      senha: senha,
    });
    return response.data;
  } catch (error) {
    throw error;
  }
};


const Login = () => {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [, setIsAuthenticated] = useState(false)

  const handleLogin = async () => {
    try {
      const response = await logar(email, senha);
      if (response == true) {
        setIsAuthenticated(true);
        window.location.href = '/manage'
      } else {
        alert("usuario nao cadastrado")
      }
    } catch (error) {
      alert('Erro ao se logar');
      console.log(error);
      console.error('Erro ao se logar:', error);
    }
  };

  return (
    <>
      <div className="main">
        <div className="container">
          <h1>
            Bem Vindo
          </h1>
          <input type="text"
            placeholder="E-Mail"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input type="password"
            placeholder="Senha"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
          />
          <button onClick={handleLogin} type="button"
          >
            ENTRAR
          </button>
        </div>
      </div>
    </>
  )
}

export default Login;
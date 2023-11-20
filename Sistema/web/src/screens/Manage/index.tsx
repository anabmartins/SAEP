import { useState, useEffect } from "react";
import { NavLink } from "react-router-dom";
import axios from 'axios'

interface Turma {
    nome: string;
}

const Manage = () => {

    const [isVisible, setIsVisible] = useState(false)

    const handleToggle = () => {
        setIsVisible(!isVisible)
    }

    const [turmas, setTurmas] = useState<Turma[]>([])
    const [nomeInput, setNomeInput] = useState("3B")

    useEffect(() => {
        fetchTurma();
    }, []);

    const fetchTurma = async () => {
        try {
            const response = await axios.get('http://localhost:8090/turmas');
            setTurmas(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    const Cadastro = async () => {
        try {
            let novaTurma = {
                nome: nomeInput,
            }
            await axios.post(`http://localhost:8090/turmas`, novaTurma)
            fetchTurma();
            // handleClick()
            setNomeInput("")
            alert(nomeInput + " cadastrado com sucesso")
        } catch (error) {
            console.log('Erro ao criar: ', error);
        }
    }

    return (
        <>
            <header>
                <p>
                    Nome Professor
                </p>
                <NavLink to="/">
                    <p>
                        Sair
                    </p>
                </NavLink>
            </header>
            <div className="main">
                <div className="containerManage">
                    <button onClick={handleToggle}>Nova Turma</button>
                    {isVisible && (
                        <div className="">
                            <p>
                                Nome da turma:
                            </p>
                            <input type="text"
                                placeholder="Ex: 3B"
                                value={nomeInput}
                                onChange={(e) => setNomeInput(e.target.value)}
                            />
                            <p>
                                <button onClick={Cadastro}>cadastrar</button>
                            </p>
                        </div>
                    )}
                    <div className="tabela">
                        <div className="col">
                            <p>Número</p>
                            {turmas.map((turma, index) => (
                                <div key={index} className="col">
                                    <p>{turma.id_turma}</p>
                                </div>
                            ))}
                        </div>
                        <div className="col">
                            <p>Nome</p>
                            {turmas.map((turma, index) => (
                                <div key={index} className="col">
                                    <p>{turma.nome}</p>
                                </div>
                            ))}
                        </div>
                        <div className="col">
                            <p>Ação</p>
                            <div className="">
                                <button>Excluir</button>
                                <NavLink to="/atividade">
                                    <button>Visualizar</button>
                                </NavLink>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Manage;
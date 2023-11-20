import { NavLink } from "react-router-dom";


const Atividade = () => {
    return (
        <>
            <header>
                <NavLink to='/manage'>
                    <p>
                        Nome Professor
                    </p>
                </NavLink>
                <NavLink to="/">
                    <p>
                        Sair
                    </p>
                </NavLink>
            </header>
            <div className="main">
                <div className="containerManage">
                    <button>Cadastrar Atividade</button>
                    <br /><br />
                    <strong>Turma:
                        <span>
                            {" Turma"}
                        </span>
                    </strong>
                    <br /><br />
                    <div className="tabela2">
                        <div className="col">
                            <p>Número</p>
                            1
                        </div>
                        <div className="col">
                            <p>Nome</p>
                            a
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Atividade;
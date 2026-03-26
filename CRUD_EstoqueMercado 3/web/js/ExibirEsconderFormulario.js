function esconderTodosCampos() {
    const campos = [
        'divId', 'divNome', 'divCategoria', 'divPreco',
        'divDataValidade', 'divPeso', 'divFornecedor',
        'divMarca', 'divCodigoBarra', 'divSku', 'divQuantidade'
    ];
    campos.forEach(id => document.getElementById(id).style.display = 'none');
}

function mostrarCampos(camposMostrar) {
    esconderTodosCampos();
    camposMostrar.forEach(id => document.getElementById(id).style.display = 'block');
}

function limparFormulario() {
    document.getElementById('formCrud').reset();
}

function mostrarFormulario(operacao) {
    adicionarBotaoVoltar(); // ⬅️ Botão volta adicionado aqui
    document.getElementById('formulario').style.display = 'block';
    document.getElementById('botoesIniciais').style.display = 'none';
    document.getElementById('op').value = operacao;
    limparFormulario();

    const botao = document.getElementById('botaoOperacao');

    switch (operacao) {
        case 'CADASTRAR':
            mostrarCampos(['divNome', 'divCategoria', 'divPreco', 'divDataValidade', 'divPeso',
                'divFornecedor', 'divMarca', 'divCodigoBarra', 'divSku', 'divQuantidade']);
            botao.value = "Cadastrar";
            botao.onclick = null;
            break;

        case 'DELETAR':
            mostrarCampos(['divId']);
            botao.value = "Deletar";
            botao.onclick = function () {
                if (document.getElementById('txtid').value.trim() === '') {
                    alert('Informe um ID para deletar.');
                    return false;
                }
                return true;
            };
            break;

        case 'CONSULTAR_ID_ATUALIZAR':
            mostrarCampos(['divId']);
            botao.value = "Buscar para Atualizar";
            botao.onclick = function () {
                if (document.getElementById('txtid').value.trim() === '') {
                    alert('Informe um ID para atualizar.');
                    return false;
                }
                document.getElementById('op').value = 'CONSULTAR_ID_ATUALIZAR';
                return true;
            };
            break;

        case 'CONSULTAR_ID':
            mostrarCampos(['divId']);
            botao.value = "Consultar";
            botao.onclick = function () {
                if (document.getElementById('txtid').value.trim() === '') {
                    alert('Informe um ID para consultar.');
                    return false;
                }
                document.getElementById('op').value = 'CONSULTAR_ID';
                return true;
            };
            break;

        case 'CONSULTAR_CATEGORIA':
            mostrarCampos(['divCategoria']);
            botao.value = "Consultar";
            botao.onclick = function () {
                if (document.querySelector('input[name="txtcategoria"]').value.trim() === '') {
                    alert('Informe uma categoria para consultar.');
                    return false;
                }
                document.getElementById('op').value = 'CONSULTAR_CATEGORIA';
                return true;
            };
            break;

        default:
            esconderTodosCampos();
            botao.value = "Enviar";
            botao.onclick = null;
    }
}

function mostrarTodos() {
    const form = document.createElement("form");
    form.method = "POST";
    form.action = "CrudEstoque";
    const op = document.createElement("input");
    op.type = "hidden";
    op.name = "op";
    op.value = "CONSULTAR_TODOS";
    form.appendChild(op);
    document.body.appendChild(form);
    form.submit();

    adicionarBotaoVoltar(); // ⬅️ Também aqui
}

// ✅ NOVA FUNÇÃO adiciona botão "Voltar ao Início"
function adicionarBotaoVoltar() {
    const existente = document.getElementById('btnVoltar');
    if (existente) existente.remove();

    const voltarBtn = document.createElement("button");
    voltarBtn.textContent = "Voltar ao Início";
    voltarBtn.id = "btnVoltar";
    voltarBtn.style.marginTop = "20px";
    voltarBtn.style.display = "block";
    voltarBtn.onclick = function () {
        window.location.href = "index.html";
    };

    document.getElementById("formulario").appendChild(voltarBtn);
}

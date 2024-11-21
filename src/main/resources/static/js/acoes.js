function renderTable() {
    const tableBody = document.getElementById("table-body");
    tableBody.innerHTML = "";

    const start = (currentPage - 1) * itensPerPage;
    const end = start + itensPerPage;
    const pageItems = itens.slice(start, end);

    if (pageItens.length === 0) {
        tableBody.innerHTML = `<tr><td colspan="5">Nenhum item encontrado.</td></tr>`;
        return;
    }

    pageItens.forEach(item => {
        const row = `<tr>
            <td>${item.nome}</td>
            <td>${item.quantidade}</td>
            <td>${item.preco}</td>
            <td>${item.dataCompra}</td>
            <td>
                <div class="action-buttons">
                    <a href="/estoque/atualizar/${item.id}" class="btn-update">Atualizar</a>
                    <form action="/api/item/deletar/${item.id}" method="post" style="display: inline;">
                        <input type="hidden" name="_method" value="delete">
                        <button type="submit" class="btn-delete">Deletar</button>
                    </form>
                </div>
            </td>
        </tr>`;
        tableBody.innerHTML += row;
    });

    document.getElementById("page-info").textContent = `Página ${currentPage} de ${Math.ceil(itens.length / itensPerPage)}`;
}

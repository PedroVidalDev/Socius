package com.pedro.socius.application.dtos.local;

import com.google.gson.JsonArray;

import java.util.List;

public record DadosRelatorioLocal(String nome, int qntHoras, List<DadosDataSocioLocal> datas) {
}

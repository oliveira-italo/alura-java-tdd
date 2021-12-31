package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @Test
    public void bonusDeveSerZeroParaSalarioMaiorQueMilReais() {
        BigDecimal bonus = new BonusService().calcularBonus(
                new Funcionario(
                        "",
                        LocalDate.now(),
                        new BigDecimal(10001)
                )
        );

        assertEquals(BigDecimal.ZERO, bonus.setScale(0));
    }

    @Test
    public void bonusDeveSerDezPorCentoParaSalarioMenorQueMilReais() {
        BigDecimal salario = new BigDecimal(9999).setScale(2);
        BigDecimal bonus = new BonusService().calcularBonus(
                new Funcionario(
                        "",
                        LocalDate.now(),
                        salario
                )
        ).setScale(2);

        assertEquals(salario.divide(new BigDecimal(10)).floatValue(), bonus.floatValue());
    }

    @Test
    public void bonusDeveSerDezPorCentoParaSalarioIgualADezMilReais() {
        BigDecimal salario = new BigDecimal(10000).setScale(2);
        BigDecimal bonus = new BonusService().calcularBonus(
                new Funcionario(
                        "",
                        LocalDate.now(),
                        salario
                )
        ).setScale(2);

        assertEquals(salario.divide(new BigDecimal(10)).floatValue(), bonus.floatValue());
    }
}
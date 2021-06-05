package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

public class PoolExercises implements Serializable {

	private static final long serialVersionUID = -4271813188647138550L;
	private List<MuscleGroup> muscleGroups;
	private final static Logger LOGGER = Logger.getLogger(PoolExercises.class);

	public PoolExercises() {
		super();
		List<MuscleGroup> muscleGroups = new ArrayList<>();
		this.muscleGroups = muscleGroups;
	}

	public void createExercises() {

		// Creating muscle groups

		MuscleGroup back = new MuscleGroup("Мышцы Спины", true);
		MuscleGroup chest = new MuscleGroup("Грудные мышцы", true);
		MuscleGroup legs = new MuscleGroup("Мышцы Ног", true);
		MuscleGroup shoulders = new MuscleGroup("Мышцы Плечевого пояса", false);
		MuscleGroup biceps = new MuscleGroup("Бицепсы", false);
		MuscleGroup triceps = new MuscleGroup("Трицепсы", false);

		this.getMuscleGroups().add(back);
		this.getMuscleGroups().add(chest);
		this.getMuscleGroups().add(legs);
		this.getMuscleGroups().add(shoulders);
		this.getMuscleGroups().add(biceps);
		this.getMuscleGroups().add(triceps);

		// Creating Exercises
		// Creating exercise for back

		Exercise deadlift = new Exercise("Становая тяга", true, back);
		deadlift.setInfo(
				"Это базовое многосуставное упражнение для мышц спины в тренажерном зале, при котором дополнительно нагружаются практически все основные группы мышц тела."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Пocтaвить cтoпы нa шиpинy плeч или чyть yжe, пapaллeльнo либo нeмнoгo paзвepнyть нocкaми нapyжy. Пoзa выбиpaeтcя индивидyaльнo, иcxoдя из yдoбcтвa выпoлнeния yпpaжнeния и тpeбoвaний мaкcимaльнoй ycтoйчивocти. Пpиcecть и взятьcя зa гpиф штaнги пpямым xвaтoм, киcти pyк нa шиpинe плeч. Kopпyc нaклoнeн впepeд, cпинa пpямaя и paзoгнyтa в пoяcницe, гpyдь pacпpaвлeнa;"
						+ "\n"
						+ "- В начале движения спина неподвижна, вес берется за счет напряжения мышц ног. Полностью выпрямить корпус, при этом колени выпрямляются в последнюю очередь;"
						+ "\n" + "- Опустить штангу по той же траектории;");
		deadlift.setIcon(new ImageIcon(this.getClass().getResource("/images/back/deadlift.gif")));
		back.getExercises().add(deadlift);

		Exercise rodPullInTilt = new Exercise("Тяга штанги в наклоне", true, back);
		rodPullInTilt.setInfo(
				"Тяга штанги в наклоне к поясу задействует широчайшие и трапециевидные мышцы спины, а также задние дельты и бицепсы."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Встать устойчиво, ноги расставить на удобную ширину, колени слегка согнуть. Наклониться и, не сгибая локти, взяться за гриф прямым хватом. Выпрямиться, подняв штангу;"
						+ "\n"
						+ "- Наклониться вперед примерно на 30 градусов, слегка прогнувшись в пояснице, штанга находится на уровне колен. Напрячь мышцы поясницы;"
						+ "\n"
						+ "- Подтянуть штангу к нижней части живота, отводя локти строго назад и поднимая их как можно выше, стараясь работать мышцами спины, а не бицепсами;"
						+ "\n" + "- Задержаться в высшей точке на 1-2 сек. и плавно вернуть штангу вниз;");
		rodPullInTilt.setIcon(new ImageIcon(this.getClass().getResource("/images/back/rodPullInTilt.gif")));
		back.getExercises().add(rodPullInTilt);

		Exercise dumbbellPullInTilt = new Exercise("Тяга гантели в наклоне", false, back);
		dumbbellPullInTilt.setInfo(
				"Тяга гантели в наклоне одной рукой прокачивает нижний край широчайших мышц. Она позволяет увеличить амплитуду движения по сравнению с традиционной тягой и снизить нагрузку на позвоночник."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Взять правой рукой гантель нейтральным хватом, рука висит свободно;" + "\n"
						+ "- Сделав вдох, подтянуть гантель к поясу или выше по дугообразной траектории, в высшей точке немного задержаться и свести лопатки;"
						+ "\n" + "- На выдохе вернуть гантель вниз;");
		dumbbellPullInTilt.setIcon(new ImageIcon(this.getClass().getResource("/images/back/dumbbellPullInTilt.gif")));
		back.getExercises().add(dumbbellPullInTilt);

		Exercise shragiStandingUp = new Exercise("Шраги стоя", false, back);
		shragiStandingUp.setInfo(
				"Для данного варианта идеально подойдут гантели или штанга с изогнутым грифом — они не будут давить на ноги или пах, как гриф обычной штанги."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Начальное положение — верхняя точка становой тяги. Не сгибая руки, поднять плечи максимально высоко;"
						+ "\n" + "- Опустить плечи, контролируя движение штанги силой мышц;");
		shragiStandingUp.setIcon(new ImageIcon(this.getClass().getResource("/images/back/shragiStandingUp.gif")));
		back.getExercises().add(shragiStandingUp);

		Exercise pullUpperBlock = new Exercise("Тяга верхнего блока к груди", true, back);
		pullUpperBlock.setInfo(
				"В основе этого упражнения для спины заложен принцип подтягиваний. Оно нагружает широчайшие мышцы, бицепсы и передние дельты."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Сесть на тренажер, взяться за его ручки широким хватом, немного согнув руки. Прогнуть поясницу и соединить лопатки;"
						+ "\n" + "- Подтянуть рукоять к верху груди, сводя лопатки еще больше;" + "\n"
						+ "- Плавно вернуть рукоять обратно;");
		pullUpperBlock.setIcon(new ImageIcon(this.getClass().getResource("/images/back/pullUpperBlock.gif")));
		back.getExercises().add(pullUpperBlock);

		// Creating exercise for chest

		Exercise benchPress = new Exercise("Жим штанги лежа", true, chest);
		benchPress.setInfo(
				"Жим лежа является базовым упражнением и по сути это прямая вариация отжиманий от пола. Особенно хорошо подходит для начинающих атлетов."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Лечь на скамью, прижав к ней голову, плечи и ягодицы. Поясницу немного прогнуть, ноги расположить шире плеч, уперев ступни в пол;"
						+ "\n"
						+ "- Взяться за штангу широким хватом, снять ее с упоров и поднять в верхнюю точку над серединой груди. При необходимости попросите партнера помочь вам в этом;"
						+ "\n"
						+ "- На глубоком вдохе опустить штангу в нижнюю точку до легкого касания груди. Зафиксировать дыхание;"
						+ "\n"
						+ "- Выжать штангу вверх до исходного положения, сделав мощный выдох ближе к конечной точке. В конечной точке выдержать небольшую паузу и максимально напрячь грудь;");
		benchPress.setIcon(new ImageIcon(this.getClass().getResource("/images/chest/benchPress.gif")));
		chest.getExercises().add(benchPress);

		Exercise pushUpsOnBars = new Exercise("Отжимания на брусьях", true, chest);
		pushUpsOnBars.setInfo(
				"Одним из важнейших упражнений для проработки мышц груди являются отжимания на брусьях. Данное упражнение представляет собой вариацию жима штанги лежа в наклоне, но движения при этом более естественные."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Принять упор на брусьях на прямых руках. Рекомендуется начинать именно из верхней позиции, так как это позволит мышцам сократиться и приготовиться к нагрузке;"
						+ "\n" + "- Наклонить торс вперед и медленно на вдохе опуститься вниз, сгибая руки в локтях;"
						+ "\n" + "- Выждать паузу и медленно подняться вверх, выпрямляя руки. Сделать выдох;");
		pushUpsOnBars.setIcon(new ImageIcon(this.getClass().getResource("/images/chest/pushUpsOnBars.gif")));
		chest.getExercises().add(pushUpsOnBars);

		Exercise spreadingArmsDumbbells = new Exercise("Разведение рук с гантелями", false, chest);
		spreadingArmsDumbbells.setInfo(
				"Это упражнение задействует лишь один сустав – плечевой, поэтому основное усилие будет сосредоточено на мышцах груди."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Сесть на скамью ближе к краю, согнув ноги в коленях;" + "\n"
						+ "- Взять гантели и поставить их на колени вертикально;" + "\n"
						+ "- Откинуться назад и лечь на скамью;" + "\n"
						+ "- Поднять чуть согнутые в локтях руки так, чтобы гантели располагались над плечами;");
		spreadingArmsDumbbells
				.setIcon(new ImageIcon(this.getClass().getResource("/images/chest/spreadingArmsDumbbells.gif")));
		chest.getExercises().add(spreadingArmsDumbbells);

		Exercise butterfly = new Exercise("Сведение рук в тренажере «Бабочка»", false, chest);
		butterfly.setInfo("-Сесть на скамью тренажера, выпрямив и плотно прижав спину." + "\n" + "\n"
				+ "Техника выполнения:" + "\n" + "\n" + "- Удобно расставить ноги на ширине плеч;" + "\n"
				+ "- Взяться за рукоятки, упереться предплечьями в подушки;" + "\n"
				+ "- После глубокого вдоха мощным движением свести руки перед собой до касания, делая выдох;" + "\n"
				+ "- На вдохе медленно развести руки в исходное положение;");
		butterfly.setIcon(new ImageIcon(this.getClass().getResource("/images/chest/butterfly.gif")));
		chest.getExercises().add(butterfly);

		Exercise mixingHandsInCrossover = new Exercise("Сведение рук в кроссовере", false, chest);
		mixingHandsInCrossover.setInfo(
				"Сведение рук на блоках позволяет проработать внутреннюю часть и низ грудных мышц." + "\n" + "\n"
						+ "Техника выполнения:" + "\n" + "\n" + "- Встать между стойками тренажера,взяться за ручки;"
						+ "\n" + "- Немного наклониться вперед,чуть согнуть руки в локтях;" + "\n"
						+ "- Одновременно обеими руками притянуть рукоятки примерно до пояса, сделав выдох в крайней точке;"
						+ "\n" + "- Медленно на вдохе вернуть руки в начальное положение;");
		mixingHandsInCrossover
				.setIcon(new ImageIcon(this.getClass().getResource("/images/chest/mixingHandsInCrossover.gif")));
		chest.getExercises().add(mixingHandsInCrossover);

		// Creating exercise for legs

		Exercise lunges = new Exercise("Выпады", true, legs);
		lunges.setInfo("Эффективное упражнение для тренировки задней части бедра." + "\n" + "\n" + "Техника выполнения:"
				+ "\n" + "\n"
				+ "- Исходное положение: прямая стойка, ноги вместе, руки на бедрах, вес тела перенесен на пятки;"
				+ "\n" + "- Приподнять правую ногу и направить пятку вперед;" + "\n"
				+ "- На выдохе сделать широкий шаг, вытянувшись;" + "\n"
				+ "- Коснувшись ногой пола, согнуть колени таким образом, чтобы правое бедро было параллельно полу, а левое – перпендикулярно. Левая нога стоит на носке;"
				+ "\n" + "- Оттолкнуться правой ногой и вернуться в исходное положение;");
		lunges.setIcon(new ImageIcon(this.getClass().getResource("/images/legs/lunges.gif")));
		legs.getExercises().add(lunges);

		Exercise lowerLegFlexion = new Exercise("Сгибание голени", false, legs);
		lowerLegFlexion.setInfo(
				"Сгибание ног в тренажере лежа – одно из изолирующих упражнений, максимально прорабатывающих двуглавую мышцу."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Исходное положение – на тренажере лицом вниз. Ноги зафиксированы валиком в районе голеностопного сустава;"
						+ "\n"
						+ "- Важно прижать туловище к скамье и не отрывать его во время движения – это позволит избежать травм;"
						+ "\n"
						+ "- Движения медленные и плавные. Использование силы инерции сведет старания спортсмена к нулю;"
						+ "\n" + "- В нижней точке колени полностью не разгибаются, ноги все время напряжены;");
		lowerLegFlexion.setIcon(new ImageIcon(this.getClass().getResource("/images/legs/lowerLegFlexion.gif")));
		legs.getExercises().add(lowerLegFlexion);

		Exercise barbellSquats = new Exercise("Приседания со штангой", true, legs);
		barbellSquats.setInfo(
				"Бесспорно, одно из лучших базовых упражнений. Превосходно развивает квадрицепсы и ягодичные мышцы, задействует мышцы спины, пресса, и задней поверхности бедра;"
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Гриф располагается на трапециях либо задних частях дельт и трапеций – ни в коем случае не на шее;"
						+ "\n" + "- Спина прямая, лопатки стянуты – так вес равномерно распределяется;" + "\n"
						+ "- Ступни располагаются немного шире плеч, но можно поставить их и еще шире для удобства и удержания равновесия;"
						+ "\n" + "- Движение начинается не с колен, а с отведения таза назад;" + "\n"
						+ "- Колени остаются неподвижны, они ни в коем случае не выходят за носки;" + "\n"
						+ "- Приседать нужно до параллели задней поверхности бедра с полом, но можно и ниже;" + "\n"
						+ "- Вставать из приседа нужно плавно, без рывков и ни в коем случае не переносить центр тяжести на носки. В верхней точке ноги не выпрямляются полностью, колено до конца подхода слегка согнуто – так снижается риск его травм;");
		barbellSquats.setIcon(new ImageIcon(this.getClass().getResource("/images/legs/barbellSquats.gif")));
		legs.getExercises().add(barbellSquats);

		Exercise gakkSquats = new Exercise("Гакк-приседания", false, legs);
		gakkSquats.setInfo(
				"Приседания в гакк-тренажере прорабатывают преимущественно квадрицепс и снижают нагрузку на спину."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "-Упражнение выполняется плавно и размеренно;" + "\n"
						+ "- В верхней точке колени не разгибаются полностью;" + "\n"
						+ "- Должна ощущаться нагрузка именно на квадрицепсы, а не на коленные суставы;" + "\n"
						+ "- Нельзя округлять грудь и выходить коленями за линию носков;");
		gakkSquats.setIcon(new ImageIcon(this.getClass().getResource("/images/legs/gakkSquats.gif")));
		legs.getExercises().add(gakkSquats);

		Exercise liftingToesSitting = new Exercise("Подъем на носки сидя", false, legs);
		liftingToesSitting.setInfo(
				"Подъем на носки сидя традиционно используется в фитнесе и бодибилдинге для тренировки икроножных и камбаловидных мышц. Упражнение универсально и подходит как новичку, так и опытному спортсмену."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n" + "- Сесть на сиденье тренажера." + "\n"
						+ "- Носки ступней расположить на опорной ступени;" + "\n"
						+ "- Пятки максимально опустить к полу;" + "\n"
						+ "- Рычаг с мягкими упорами опустить на колени и зафиксировать;");
		liftingToesSitting.setIcon(new ImageIcon(this.getClass().getResource("/images/legs/liftingToesSitting.gif")));
		legs.getExercises().add(liftingToesSitting);

		// Creating exercise for shoulders

		Exercise armyBenchPress = new Exercise("Армейский жим", true, shoulders);
		armyBenchPress.setInfo(
				"«Аpмeйcкий жим» являeтcя ocнoвным тpeнингoм нa плeчи. Xoть oн и вoздeйcтвyeт пpeимyщecтвeннo нa cpeдний пyчoк, двa ocтaльныx тoжe aктивнo paбoтaют."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n" + "- Стоя. Ноги на ширине плеч;" + "\n"
						+ "- Взять снаряд прямым хватом на ширине плеч и поднять на уровень груди;" + "\n"
						+ "- Поднять снаряд вверх, делая выдох в конце подъема;" + "\n"
						+ "- Сделать паузу и медленно на вдохе опустить штангу на уровень груди;");
		armyBenchPress.setIcon(new ImageIcon(this.getClass().getResource("/images/shoulders/armyBenchPress.gif")));
		shoulders.getExercises().add(armyBenchPress);

		Exercise pressFromBehindHead = new Exercise("Жим штанги из-за головы", true, shoulders);
		pressFromBehindHead.setInfo("Базовый тренинг для развития плечевого пояса. Выполняется в положении сидя." + "\n"
				+ "\n" + "Техника выполнения:" + "\n" + "\n"
				+ "- Сесть на спортивную скамью, cпину слегка прогнуть, xват достаточно широкий;" + "\n"
				+ "- На выдохе выжать снаряд вверх. Руки должны полностью выпрямиться;" + "\n"
				+ "- На вдохе опустить штангу за голову;");
		pressFromBehindHead
				.setIcon(new ImageIcon(this.getClass().getResource("/images/shoulders/pressFromBehindHead.gif")));
		shoulders.getExercises().add(pressFromBehindHead);

		Exercise arnoldBenchPress = new Exercise("Жим Арнольда", false, shoulders);
		arnoldBenchPress.setInfo(
				"Данное упражнение является вариацией жима над головой с гантелями, но с начальной позицией рук перед собой."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Сидя на скамье со строго вертикальной спинкой, плотно прижавшись к ней спиной;" + "\n"
						+ "- Гантели поднять на уровень шеи. Локти согнуть под прямым углом;" + "\n"
						+ "- Кисти развернуть ладонями к себе;" + "\n"
						+ "- На выдохе выжать гантели вертикально вверх, при этом разворачивая кисти ладонями наружу;"
						+ "\n" + "- В верхней точке ладони должны быть направлены вперед. Сделать небольшую паузу;"
						+ "\n"
						+ "- На вдохе плавно вернуть гантели в исходное положение, разворачивая ладони в обратной последовательности;");
		arnoldBenchPress.setIcon(new ImageIcon(this.getClass().getResource("/images/shoulders/arnoldBenchPress.gif")));
		shoulders.getExercises().add(arnoldBenchPress);

		Exercise dumbbellLiftsThroughTheSides = new Exercise("Подъемы гантелей через стороны", false, shoulders);
		dumbbellLiftsThroughTheSides.setInfo(
				"Это упражнение можно выполнять в домашних условиях. Оно уже не является базовым, а направлено на проработку боковой поверхности дельтовидной мышцы."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Встать прямо и слегка наклониться вперед, взять гантели и опустить руки вниз;" + "\n"
						+ "- Сделать глубокий вдох. Развести руки с гантелями в стороны на уровень плеч;" + "\n"
						+ "- В конечном положении задняя часть снаряда должна быть слегка приподнята;" + "\n"
						+ "- На выдохе плавно опустить руки обратно;");
		dumbbellLiftsThroughTheSides.setIcon(
				new ImageIcon(this.getClass().getResource("/images/shoulders/dumbbellLiftsThroughTheSides.gif")));
		shoulders.getExercises().add(dumbbellLiftsThroughTheSides);

		Exercise liftingDumbbellsInTilt = new Exercise("Подъемы гантелей через стороны в наклоне", false, shoulders);
		liftingDumbbellsInTilt.setInfo("Изолированное упражнение, которое прорабатывает заднюю часть дельт." + "\n"
				+ "\n" + "Техника выполнения:" + "\n" + "\n"
				+ "- Встать прямо, взять снаряд в руки и наклониться вперед под углом в 45 градусов, pуки с гантелями опустить вниз;"
				+ "\n" + "- Глубоко вдохнуть. Развести гантели в стороны, стараясь поднять их как можно выше;" + "\n"
				+ "- Плавно вернуть руки в исходное положение, делая выдох;");
		liftingDumbbellsInTilt
				.setIcon(new ImageIcon(this.getClass().getResource("/images/shoulders/liftingDumbbellsInTilt.gif")));
		shoulders.getExercises().add(liftingDumbbellsInTilt);

		// Creating exercise for biceps

		Exercise armFlexionWithDumbbells = new Exercise("Сгибание рук с гантелями", false, biceps);
		armFlexionWithDumbbells.setInfo(
				"Сгибания рук с гантелями – упражнение для изолированной проработки бицепса. Атлеты выполняют сгибания рук с гантелями с целью увеличить объем бицепса, а также сильнее развить его пик."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Cесть на стул, взять гантели, сгибать и разгибать руки в локтевых суставах;" + "\n"
						+ "- Разгибать и сгибать руки следует медленно;");
		armFlexionWithDumbbells
				.setIcon(new ImageIcon(this.getClass().getResource("/images/biceps/armFlexionWithDumbbells.jpg")));
		biceps.getExercises().add(armFlexionWithDumbbells);

		Exercise hammers = new Exercise("Молотковый подъем гантелей", false, biceps);
		hammers.setInfo("Данное упражнение прокачивает боковую часть бицепса, формируя его." + "\n" + "\n"
				+ "Техника выполнения:" + "\n" + "\n"
				+ "- Встать прямо, руки с гантелями опущены вниз по бокам туловища;" + "\n"
				+ "- Кисти развернуты пальцами к бедру (нейтральный хват);" + "\n"
				+ "- Поочередно поднимать гантели к плечу;");
		hammers.setIcon(new ImageIcon(this.getClass().getResource("/images/biceps/hammers.jpg")));
		biceps.getExercises().add(hammers);

		Exercise liftingRodOnBiceps = new Exercise("Подъем штанги на бицепс", true, biceps);
		liftingRodOnBiceps.setInfo(
				"Подъем штанги на бицепс стоя — это базовое упражнение на бицепс. Оно считается одним из самых эффективных для наращивания объёма и силы бицепсов."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- За гриф штанги нужно браться на ширине плеч, хватом снизу;" + "\n"
						+ "- Поднять штангу к груди;" + "\n" + "- Cледить за тем, чтобы локти не выносились вперед;");
		liftingRodOnBiceps.setIcon(new ImageIcon(this.getClass().getResource("/images/biceps/liftingRodOnBiceps.jpg")));
		biceps.getExercises().add(liftingRodOnBiceps);

		// Creating exercise for triceps

		Exercise pressWithNarrowGrip = new Exercise("Жим лежа узким хватом", true, triceps);
		pressWithNarrowGrip.setInfo(
				"Жим штанги узким хватом – это многосуставное упражнение для трицепсов. Во время выполнения упражнения нагрузка распространяется одновременно на три головки трехглавой мышцы плеча."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Лежа на скамье. Спина, лопатки и ягодицы плотно прижаты;" + "\n"
						+ "- Взять штангу. Хват прямой. Между ладонями расстояние в 2-3 кулака;" + "\n"
						+ "- На выдохе опустить штангу под грудные мышцы и, коснувшись тела, сразу же поднимите ее вверх;"
						+ "\n" + "- Когда руки полностью распрямятся, сделайте выдох;" + "\n"
						+ "- В верхнем положении можно сделать остановку и снова повторить упражнение;");
		pressWithNarrowGrip
				.setIcon(new ImageIcon(this.getClass().getResource("/images/triceps/pressWithNarrowGrip.jpg")));
		triceps.getExercises().add(pressWithNarrowGrip);

		Exercise armExtensionOnBlock = new Exercise("Разгибание рук на блоке", false, triceps);
		armExtensionOnBlock.setInfo(
				"Это лучшее упражнение на трицепс, которое позволяет прорабатывать исключительно эту мышцу. Является изолирующим упражнением."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n" + "- Стоя, корпус слегка прогнут вперед"
						+ "\n"
						+ "- Взяться за рукоятку так, чтобы ладони были обращены к полу, руки расположены в среднем положении;"
						+ "\n" + "- Локти плотно прижаты к телу;" + "\n" + "- Подтянуть рукоятку к верхней части груди;"
						+ "\n" + "- С выдохом разогнуть руки, стараясь опустить рукоятку как можно ниже к бедрам;"
						+ "\n" + "- Задержаться в этом положении;" + "\n"
						+ "- Затем медленно согнуть руки, делая вдох и возвращая рукоятку в исходное положение;");
		armExtensionOnBlock
				.setIcon(new ImageIcon(this.getClass().getResource("/images/triceps/armExtensionOnBlock.jpg")));
		triceps.getExercises().add(armExtensionOnBlock);

		Exercise frenchBenchPress = new Exercise("Французский жим лежа", true, triceps);
		frenchBenchPress.setInfo(
				"Это упражнение выполняется не с предельным весом. Оно предназначено для тренировки именно трицепсов."
						+ "\n" + "\n" + "Техника выполнения:" + "\n" + "\n"
						+ "- Лежа на скамье, cпина и ягодицы плотно прижаты;" + "\n"
						+ "- Штанга в вытянутых руках, хват прямой, руки на ширине плеч;" + "\n"
						+ "- С вдохом опустить штангу ко лбу, плечи и предплечья должны образовать прямой угол;" + "\n"
						+ "- Задержать снаряд в этом положении, c выдохом поднять штангу так, чтобы руки распрямились полностью;");
		frenchBenchPress.setIcon(new ImageIcon(this.getClass().getResource("/images/triceps/frenchBenchPress.jpg")));
		triceps.getExercises().add(frenchBenchPress);

		Program programForBeginners = new Program("Программа для новичков");
		for (int i = 0; i < 3; i++) {
			programForBeginners.getExercises().add(pullUpperBlock);
			programForBeginners.getExercises().add(benchPress);
			programForBeginners.getExercises().add(armyBenchPress);
			programForBeginners.getExercises().add(barbellSquats);
			programForBeginners.getExercises().add(armFlexionWithDumbbells);
			programForBeginners.getExercises().add(armExtensionOnBlock);
		}
		List<Program> programs = new ArrayList<Program>();
		programs.add(programForBeginners);
		File file = new File("Programs.txt");
		if (file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				LOGGER.error("Проблемы с создание file" + e);
			}
		}
		if (file.length() == 0) {
			try {
				ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
				ous.writeObject(programs);
				ous.close();
			} catch (IOException e) {
				LOGGER.error("Проблемы с записью в file" + e);
			}
		}
	}

	public List<MuscleGroup> getMuscleGroups() {
		return muscleGroups;
	}

	public void setMuscleGroups(List<MuscleGroup> muscleGroups) {
		this.muscleGroups = muscleGroups;
	}

}
